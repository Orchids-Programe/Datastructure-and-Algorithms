package  bai4.queue;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    class Node {
        E element;
        Node next;
    }
    private Node top = null;
    private Node tail = null;
    private int n = 0;

    public void enqueue(E element) {
        Node newNode = new Node();
        newNode.element = element;
        if (isEmpty()) {
            top = newNode;
            tail = newNode;
            n++;
        } else {
            tail.next = newNode;
            tail = newNode;
            n++;
        }
    }

    public E dequeue() {
        E result = top.element;
        top = top.next;
        n--;
        return result;
    }

    public E first() {
        if (!isEmpty()) {
            return top.element;
        }
        
        return null;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return (n == 0);
    }

    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new QueueIterator();

    }
    
    class QueueIterator implements Iterator<E>{
        private Node current = top;
        private int num = n;

        public boolean hasNext(){
            return num == 0;
        }

        public E next(){
            E data = current.element;
            current = current.next;
            num--;
            return data;
        }
    }
}