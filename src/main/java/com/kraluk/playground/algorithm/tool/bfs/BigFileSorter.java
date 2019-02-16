package com.kraluk.playground.algorithm.tool.bfs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.apache.commons.lang3.Validate.isTrue;

/**
 * Sorts a huge file containing integers
 *
 * @author lukasz
 */
public class BigFileSorter {
    private static final Logger log = LogManager.getLogger(BigFileSorter.class);

    private final Path inputFile;
    private final Path outputFile;

    public BigFileSorter(final Path inputFile, final Path outputFile) {
        isTrue(Files.isRegularFile(inputFile), "Input file should be a regular file!");
        isTrue(Files.isRegularFile(outputFile), "Output file should be a regular file!");

        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public void sort() {
        log.info("Attempting to sort file '{}'...", inputFile);

        throw new UnsupportedOperationException("Unsupported sorting method!");

        //log.info("Successfully sorted the given file. Output has been produced to '{}'.", outputFile);
    }
}
