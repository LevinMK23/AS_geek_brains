package Stack;

import java.util.Iterator;

public class Stack<T> implements LIFO<T> {

    private Node<T> tail;
    private int size;

    public Stack() {
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T pop() {
        // TODO: 18/11/2019
        return null;
    }

    @Override
    public T peek() {
        return tail.getValue();
    }

    @Override
    public void push(T value) {
        // TODO: 18/11/2019

    }

    @Override
    public void show() {
        // TODO: 18/11/2019
    }

    private Node<T> iterNode;

    @Override
    public Iterator<T> iterator() {
        iterNode = tail;
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return iterNode != null;
            }

            @Override
            public T next() {
                T val = iterNode.getValue();
                iterNode = iterNode.getPrev();
                return val;
            }
        };
    }
}
