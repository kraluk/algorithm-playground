package com.kraluk.playground.algorithm.task.various.structure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Singly LinkedList operations
 *
 * @author lukasz
 */
public class SinglyLinkedList {
    private static final Logger log = LogManager.getLogger(SinglyLinkedList.class);

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

    private static class Node {
        public int value;
        public Node next;

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
}