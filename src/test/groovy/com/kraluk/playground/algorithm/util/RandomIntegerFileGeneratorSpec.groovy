package com.kraluk.playground.algorithm.util

import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Path

import static spock.util.matcher.HamcrestMatchers.closeTo

class RandomIntegerFileGeneratorSpec extends Specification {

    final def ACCEPTABLE_ERROR = 1e-2
    final def SIZE = 0.1

    Path outputDirectory
    Path outputFile

    void setup() {
        outputDirectory = Files.createTempDirectory("fg")
        outputFile = Files.createTempFile(outputDirectory, "gen", ".txt")
    }

    def "generates a file with a given size"() {
        given:
        def generator = new RandomIntegerFileGenerator(SIZE, outputFile)

        when:
        generator.generate()

        then:
        def outputSize = Files.size(outputFile) / 1_000_000_000

        and:
        outputSize closeTo(SIZE, ACCEPTABLE_ERROR)
    }

    def "throws an IllegalArgumentException when output is not a regular file"() {
        when:
        new RandomIntegerFileGenerator(SIZE, outputDirectory)

        then:
        thrown(IllegalArgumentException)
    }

    void cleanup() {
        Files.delete(outputFile)
        Files.delete(outputDirectory)
    }
}
