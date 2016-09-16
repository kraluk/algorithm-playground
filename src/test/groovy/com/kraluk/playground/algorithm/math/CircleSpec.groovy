package com.kraluk.playground.algorithm.math

import spock.lang.Specification

import static spock.util.matcher.HamcrestMatchers.closeTo

class CircleSpec extends Specification {

    def "calculates circle area"() {

        given:
        Double r = 5.0;

        when:
        Double area = Circle.calculateArea(r);

        then:
        area closeTo(Math.PI * r * r, 0.01)
    }
}