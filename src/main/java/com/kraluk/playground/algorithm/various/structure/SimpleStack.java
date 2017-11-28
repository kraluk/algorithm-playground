package com.kraluk.playground.algorithm.various.structure;

import java.util.LinkedList;
import java.util.List;

/**
 * Simple not-synchronized Stack implementation
 */
public final class SimpleStack<T> {

    private Node<T> head;

    public void push(final T value) {
        head = new Node<>(head, value);
    }

    public void push(final List<T> values) {
        for (T value : values) {
            push(value);
        }
    }

    public T pop() {
        T value = head.getValue();
        head = head.getParent();

        return value;
    }

    public List<T> popAll() {
        final List<T> result = new LinkedList<>();

        Node<T> node = head;

        while (node != null) {
            result.add(node.getValue());
            node = node.getParent();
        }

        return result;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // --- Node

    private static final class Node<V> {
        private final Node<V> parent;

        private final V value;

        Node(final Node<V> parent, final V value) {
            this.parent = parent;
            this.value = value;
        }

        V getValue() {
            return value;
        }

        Node<V> getParent() {
            return parent;
        }
    }
}
