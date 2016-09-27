package com.kraluk.playground.algorithm.various.math

import com.kraluk.playground.algorithm.various.math.Circle
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