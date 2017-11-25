package com.kraluk.playground.algorithm.various.structure

import com.kraluk.playground.algorithm.various.structure.SinglyLinkedList.Node
import spock.lang.Specification

class SinglyLinkedListSpec extends Specification {

    def "reverse a singly linked list"() {

        given:
        def node1 = new Node(1);
        def node2 = new Node(2);
        def node3 = new Node(3);
        def node4 = new Node(4);
        def node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

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