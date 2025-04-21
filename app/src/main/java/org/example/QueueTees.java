package org.example;

public class QueueTees<T extends Cutie> {

    private static class Node<T> {
        private final T data;
        private Node<T> next;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int sizeCount;

    public T peek() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;
    }

    public void enqueue(T data) {
        Node<T> node = new Node<>(data);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
        sizeCount++;
    }

    public T dequeue() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        sizeCount--;
        return data;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        return sizeCount;
    }
}
