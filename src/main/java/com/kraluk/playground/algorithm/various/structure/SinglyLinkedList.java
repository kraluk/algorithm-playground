package com.kraluk.playground.algorithm.various.structure;

import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Singly LinkedList operations
 *
 * @author lukasz
 */
@Log4j2
public class SinglyLinkedList {

    public static Node reverse(Node head) {
        Node headOfUnreversed = head;
        Node headOfReversed = null;
        Node nodeToReverse = null;

        while (headOfUnreversed != null) {
            log.info("---------");

            headOfReversed = nodeToReverse;
            nodeToReverse = headOfUnreversed;
            headOfUnreversed = headOfUnreversed.next;
            nodeToReverse.next = headOfReversed;

            log.info("U: " + headOfUnreversed);
            log.info("R: " + headOfReversed);
            log.info("---------");
        }

        headOfReversed = nodeToReverse;

        log.info("Final R: " + headOfReversed);
        return headOfReversed;
    }

    @ToString
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}