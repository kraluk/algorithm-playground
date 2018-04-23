package com.kraluk.playground.algorithm.bfs

import com.kraluk.playground.algorithm.util.RandomIntegerFileGenerator
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

import java.nio.file.Files
import java.nio.file.Path

@Ignore
class BigFileSorterSpec extends Specification {

    Path testDirectory
    Path inputFile
    Path outputFile

    void setup() {
        initFiles()
    }

    def "should sort all numbers in the file"() {
        given:
        def sorter = new BigFileSorter(inputFile, outputFile)
        and:
        generateInputFile(0.1)

        when:
        sorter.sort()

        then:
        assert Files.isRegularFile(outputFile)
    }

    @Unroll
    def "should thrown an exception when input and/or output files are not a regular ones"() {
        when:
        new BigFileSorter(input, output)
        and:
        generateInputFile(0.001)

        then:
        thrown(IllegalArgumentException)

        where:
        input                                                          || output
        Files.createTempDirectory(BigFileSorter.class.getSimpleName()) || Files.createTempFile("file", ".txt")
        Files.createTempFile("file", ".txt")                           || Files.createTempDirectory(BigFileSorter.class.getSimpleName())
        Files.createTempDirectory(BigFileSorter.class.getSimpleName()) || Files.createTempDirectory(BigFileSorter.class.getSimpleName())
    }

    void cleanup() {
        Files.delete(inputFile)
        Files.delete(outputFile)
        Files.delete(testDirectory)
    }

    void initFiles() {
        testDirectory = Files.createTempDirectory(BigFileSorterSpec.class.getSimpleName())
        inputFile = Files.createTempFile(testDirectory, "input", ".txt")
        outputFile = Files.createTempFile(testDirectory, "output", ".txt")
    }

    void generateInputFile(final double size) {
        def generator = new RandomIntegerFileGenerator(size, inputFile)

        generator.generate()
    }
}
