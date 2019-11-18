package classWork.queue;

import java.util.Iterator;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Fifo queue = new ArrayPriorityQueue();
        //queue.top();
        //поиск минимума к коллекции любой длины за O(1)
        //извлечение минимума за О(logN)
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            queue.push(r.nextInt(1000));
        }
        queue.forEach(System.out::println);
        //HeapSort
        while (!queue.isEmpty()) {
            System.out.print(queue.pop() + " ");
        }
    }
}
