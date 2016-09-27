package com.kraluk.playground.algorithm.various.structure;

import lombok.extern.slf4j.Slf4j;

/**
 * Singly LinkedList operations
 *
 * @author lukasz
 */
@Slf4j
public class SinglyLinkedList {

    private static Node prepareInput() {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        return node1;
    }

    public static Node reverse(Node head) {
        Node headOfUnreversed = head;
        Node headOfReversed = null;
        Node nodeToReverse = null;

        log.info("---------");
        while (headOfUnreversed != null) {

            headOfReversed = nodeToReverse;
            nodeToReverse = headOfUnreversed;
            headOfUnreversed = headOfUnreversed.next;
            nodeToReverse.next = headOfReversed;

            log.info("U " + headOfUnreversed);
            log.info("R " + headOfReversed);
            log.info("---");

        }
        log.info("---------");

        headOfReversed = nodeToReverse;

        log.info("R " + headOfReversed);
        return headOfReversed;
    }

    public static void main(String[] args) {
        Node unreversed = prepareInput();
        log.info("{}", unreversed);

        Node reversed = reverse(unreversed);
        log.info("{}", reversed);
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
            "value=" + value +
            ", next=" + next +
            '}';
    }
}
