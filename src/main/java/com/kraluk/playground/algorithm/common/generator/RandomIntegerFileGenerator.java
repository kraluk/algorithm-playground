package com.kraluk.playground.algorithm.common.generator;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.Validate.isTrue;

/**
 * Random *integer* numbers file generator
 *
 * @author lukasz
 */
public final class RandomIntegerFileGenerator {
    private static final Logger log = LogManager.getLogger(RandomIntegerFileGenerator.class);

    private static final double GIG = 1_000_000_000;
    private static final int CHUNK_CHECK_SIZE = 10_000;
    private static final int BLOCK_SIZE = 100;

    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private final double outputSize;
    private final Path output;

    /**
     * Creates instance of {@link RandomIntegerFileGenerator}
     *
     * @param outputSize size of the output file in gigabytes
     * @param output     a {@link Path} representing output file
     */
    public RandomIntegerFileGenerator(final double outputSize, final Path output) {
        isTrue(Files.isRegularFile(output), "Output Path should be a regular file!");

        this.outputSize = outputSize * GIG; // gigabyte in bytes
        this.output = output;
    }

    /**
     * Generates a file containing {@link #outputSize} GB random integers.
     * <br/>
     * Due to performance reasons, we're not checking the produced file's size after each write
     * (it means after writing one block of hundred numbers), but after writing {@link #CHUNK_CHECK_SIZE}
     * blocks - this solution provides some problems with estimating the size of an output file,
     * which at the end should contain approximately the given amount of data.
     *
     * @throws IOException when there will be some problems with the IO operations
     */
    public void generate() throws IOException {
        log.info(format("Attempting to generate file with size %.3f GB", outputSize / GIG));

        final StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        try (final PrintWriter writer = createPrintWriter()) {
            int chunkCounter = 0;

            while (true) {
                writeNumberBlock(writer);

                ++chunkCounter;

                if (chunkCounter == CHUNK_CHECK_SIZE) {
                    final long size = Files.size(output); // bleh, heavy IO operation...

                    log.debug(() -> format("Size: %.3f GB", size / GIG));

                    if (size >= outputSize) {
                        break;
                    } else {
                        chunkCounter = 0;
                    }
                }
            }
        }

        stopWatch.stop();
        final long time = stopWatch.getTime(TimeUnit.SECONDS);

        log.info(format("Took %.1f seconds to create a file of %.3f GB", (double) time,
            Files.size(output) / GIG));
    }

    private void writeNumberBlock(final PrintWriter writer) {
        writer.print(EMPTY);
        writer.print(generateNumber());

        IntStream.range(1, BLOCK_SIZE).forEach(i -> {
            writer.print(SPACE);
            writer.print(generateNumber());
        });

        writer.println();
    }

    private int generateNumber() {
        return RandomUtils.nextInt(0, Integer.MAX_VALUE);
    }

    private PrintWriter createPrintWriter() throws IOException {
        return new PrintWriter(
            new BufferedWriter(
                new OutputStreamWriter(
                    Files.newOutputStream(output), DEFAULT_CHARSET)), false);
    }
}
