import java.util.ArrayList;

import static java.lang.Math.max;

public class MyHashSet<T> {

    private int size, capacity, maxDepth;
    private Node<T> [] table;
    //LinkedList<T> [] table

    public MyHashSet() {
        size = 0;
        capacity = 17;
        maxDepth = 0;
        table = (Node<T>[]) new Object[capacity];

    }

    public int size(){
        return size;
    }

    public void add(T value){
        int idx = hash(value);
        if (table[idx] == null) {
            table[idx] = new Node<>(value);
            size++;
        } else {
            Node<T> cur = table[idx];
            int cnt = 0;
            while (cur != null) {
                cnt++;
                if (cur.value.equals(value)) return;
                if (cur.next == null) {
                    cur.next = new Node<>(value);
                    cur.next.prev = cur;
                    size++;
                    return;
                }
                cur = cur.next;
                maxDepth = max(cnt, maxDepth);
            }
        }
    }

    public void remove(T value){
        int idx = hash(value);
        if (table[idx] != null) {
            Node<T> cur = table[idx];
            while (cur != null) {
                if (cur.value.equals(value)) {
                    //TODO
                }
                cur = cur.next;
            }
        }
    }

    public boolean contains(T value){
        int idx = hash(value);
        if (table[idx] == null) {
            return false;
        }
        else {
            Node<T> cur = table[idx];
            while (cur != null) {
                if (cur.value.equals(value)) return true;
                cur = cur.next;
            }
        }
        return false;
    }

    //можно использовать хеш объекта
    private int hash(T value){
        return (value.hashCode()) % capacity;
    }

    //0.2
    private double quality(){
        return (double)maxDepth / table.length;
    }

    private void rehash(){
        if(quality() > 0.2) {
            //TODO
            ArrayList<T> list = new ArrayList<>();
            for (int i = 0; i < capacity; i++) {
                if (table[i] != null) {
                    Node<T> cur = table[i];
                    while (cur != null) {
                        list.add(cur.value);
                        cur = cur.next;
                        cur.prev = null;
                    }
                }
            }
            capacity = genNextPrime(2 * capacity);
            table = (Node<T>[]) new Object[capacity];
            for (T el : list) {
                add(el);
            }
        }
    }

    private int genNextPrime(int n){
        //TODO
        return n;
    }

    //проверяет простое число или нет
    //простое - это число которое делится
    //только на себя или на 1
    private boolean isPrime(int n){
        //TODO
        return false;
    }
}
