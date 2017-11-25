package com.kraluk.playground.algorithm.various.sort

import spock.lang.Specification

class BubbleSortSpec extends Specification {

    def "sort given array with Bubble Sort"() {

        given:
        int[] array = [345, 2, 34, 1, 999, 0, 555]
        int[] sorted = [0, 1, 2, 34, 345, 555, 999]

        when:
        BubbleSort.sort(array)

        then:
        array == sorted
    }

    def "sort given array with Bubble Sort (inverse)"() {

        given:
        int[] array = [345, 2, 34, 1, 999, 0, 555]
        int[] sorted = [0, 1, 2, 34, 345, 555, 999]

        when:
        BubbleSort.sortInverse(array)

        then:
        array == sorted
    }

    def "compare normal and inverse Bubble Sort"() {

        given:
        int[] array1 = [345, 2, 34, 1, 999, 0, 555]
        int[] array2 = [345, 2, 34, 1, 999, 0, 555]

        when:
        BubbleSort.sortInverse(array1)
        BubbleSort.sortInverse(array2)

        then:
        array1 == array2
    }
}