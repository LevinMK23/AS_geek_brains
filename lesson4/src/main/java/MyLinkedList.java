import classwork.LinkList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> head, tail, iteratorNode;
    private Iterator<T> iterator;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public Iterator<T> iterator() {

        iteratorNode = head;

        return new Iterator<T>() {

            public void remove() {
                iteratorNode = iteratorNode.prev;
                Node<T> prev = iteratorNode.prev, next = iteratorNode.next;
                if (prev == next && prev == null) {
                    head = tail = null;
                } else if(prev == null){
                    head = head.next;
                    head.prev.next = null;
                    head.prev = null;
                } else if(next == null) {
                    tail = tail.prev;
                    tail.next.prev = null;
                    tail.next = null;
                } else {
                    prev.next.prev = null;
                    prev.next = null;
                    next.prev.next = null;
                    next.prev = null;
                    next.prev = prev;
                    prev.next = next;
                }
                iteratorNode = next;
                size--;
            }

            @Override
            public boolean hasNext() {
                return iteratorNode != null;
            }

            @Override
            public T next() {
                T value = iteratorNode.value;
                iteratorNode = iteratorNode.next;
                return value;
            }
        };
    }

    void sortedAdd(T element) {
        //TODO
        //вставляем с головы в ближайшее место,
        //для которого выполняется:
        //node.prev <= tmp <= node.next
    }

    public T first() {
        return head.value;
    }


    public T last() {
        return tail.value;
    }

    void add(T element) {
        if (size == 0) {
            head = tail = new Node<>(element);
        } else {
            tail.next = new Node<>(element);
            tail.next.prev = tail;
            tail = tail.next;
        }
        size++;
    }

    void add(int index, T element) {
        if(size == 0 && index == 0){
            head = tail = new Node<>(element);
            size++;
            return;
        }
        if (index == 0) {
            head.prev = new Node<>(element);
            head.prev.next = head;
            head = head.prev;
            size++;
            return;
        }
        if (index >= size) throw new ArrayIndexOutOfBoundsException();
        Node<T> node = head;
        int cnt = 0;
        while (cnt < index){
            node = node.next;
            cnt++;
        }
        Node<T> tmp = new Node<>(element);
        Node<T> last = node.prev;
        last.next = tmp;
        node.prev = tmp;
        tmp.next = node;
        tmp.prev = last;
        size++;
    }

    void remove() {
        //TODO
    }

    int size() {
        //TODO
        return size;
    }

    void remove(int index) {
        //TODO
    }

    T get(int index) {
        //TODO
        return null;
    }

    void set(int index, T value) {
        //TODO
    }

    @Override
    public String toString() {
        //TODO
        //format: [1, 2, 3, 4, 5]
        return "";
    }

}
