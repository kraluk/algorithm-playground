package com.kraluk.playground.algorithm.task.various.structure

import spock.lang.Specification

class SimpleStackSpec extends Specification {

    def stack

    def setup() {
        stack = new SimpleStack<String>()
    }

    def "should perform single push operation properly"() {
        when:
        stack.push(value)

        then:
        stack.head.getValue() == value

        where:
        value << ["test", "zwei"]
    }

    def "should perform multi push operation properly"() {
        when:
        stack.push(value)

        then:
        stack.pop() == value[1]
        stack.pop() == value[0]

        where:
        value = ["test", "zwei"]
    }

    def "should perform pop operation properly"() {
        given:
        stack.push(value)

        when:
        def result = stack.pop()

        then:
        result == value

        where:
        value << ["test", "zwei"]
    }

    def "should perform pop all operation properly"() {
        given:
        stack.push(value)

        when:
        def result = stack.popAll()

        then:
        result == value.reverse()

        where:
        value = ["test", "zwei", "drei", "vier"]
    }

    def "should check if stack is empty or not"() {
        given:
        def anotherStack = new SimpleStack<String>()

        when:
        operation(anotherStack)
        and:
        def result = anotherStack.isEmpty()

        then:
        result == expected

        where:
        operation << [{ stack -> stack.push("test") }, { stack -> }]
        expected << [false, true]

    }
}