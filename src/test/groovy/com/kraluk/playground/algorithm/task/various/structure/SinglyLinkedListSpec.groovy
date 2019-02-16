package com.kraluk.playground.algorithm.task.various.structure


import spock.lang.Specification

class SinglyLinkedListSpec extends Specification {

    def "reverse a singly linked list"() {

        given:
        def node1 = new SinglyLinkedList.Node(1)
        def node2 = new SinglyLinkedList.Node(2)
        def node3 = new SinglyLinkedList.Node(3)
        def node4 = new SinglyLinkedList.Node(4)
        def node5 = new SinglyLinkedList.Node(5)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = null

        when:
        SinglyLinkedList.reverse(node1)

        then:
        node5.next == node4
        node4.next == node3
        node3.next == node2
        node2.next == node1
        node1.next == null
    }
}