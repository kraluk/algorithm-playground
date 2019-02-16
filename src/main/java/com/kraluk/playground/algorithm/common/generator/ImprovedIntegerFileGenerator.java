package com.kraluk.playground.algorithm.common.generator;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;
import static org.apache.commons.lang3.Validate.isTrue;

/**
 * Random *integer* numbers file generator
 *
 * @author lukasz
 */
public final class ImprovedIntegerFileGenerator {
    private static final Logger log = LogManager.getLogger(ImprovedIntegerFileGenerator.class);

    private static final long GIG = 1_000_000_000;

    private final long outputSize;
    private final Path output;

    /**
     * Creates instance of {@link ImprovedIntegerFileGenerator}
     *
     * @param outputSize size of the output file in gigabytes
     * @param output     a {@link Path} representing output file
     */
    public ImprovedIntegerFileGenerator(final double outputSize, final Path output) {
        isTrue(Files.isRegularFile(output), "Output Path should be a regular file!");

        this.outputSize = (long) (outputSize * GIG); // gigabyte in bytes
        this.output = output;
    }


    public void generate() throws IOException {
        log.info("Attempting to generate file with size {} bytes", outputSize);

        final StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        final Runtime runtime = Runtime.getRuntime();
        log.info("Memory information: {} {} {}", runtime.freeMemory(), runtime.totalMemory(), runtime.maxMemory());

        try (final FileChannel channel = new RandomAccessFile(output.toFile(), "rw").getChannel()) {
            final ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, outputSize);
            final StringBuilder builder = new StringBuilder();

            int size = (int) outputSize - String.valueOf(Integer.MAX_VALUE).length();
            int lineCounter = 0;

            while (builder.length() <= size) {

                builder.append(generateNumber())
                    .append(StringUtils.SPACE);

                lineCounter++;

                if (lineCounter == 10) {
                    builder.append(System.lineSeparator());
                    lineCounter = 0;
                }
            }

            final byte[] bytes = builder.toString().getBytes();
            buffer.put(bytes);
        }

        stopWatch.stop();
        final long time = stopWatch.getTime(TimeUnit.SECONDS);

        log.info(format("Took %.1f seconds to create a file of %s bytes", (double) time,
            Files.size(output)));
    }

    private int generateNumber() {
        return RandomUtils.nextInt(0, Integer.MAX_VALUE);
    }
}
