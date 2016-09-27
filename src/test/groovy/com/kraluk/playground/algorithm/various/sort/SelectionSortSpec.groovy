package com.kraluk.playground.algorithm.various.sort

import com.kraluk.playground.algorithm.various.sort.SelectionSort
import spock.lang.Specification

class SelectionSortSpec extends Specification {

    def "sort given array with Selection Sort"() {

        given:
            int[] array = [345, 2, 34, 1, 999, 0, 555]
            int[] sorted = [0, 1, 2, 34, 345, 555, 999]

        when:
            SelectionSort.sort(array)

        then:
            array == sorted
    }
}