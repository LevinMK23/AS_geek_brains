package classWork;

import java.util.ArrayList;
import java.util.Random;

public class BinarySearch<T extends Comparable<T>>
        implements Search<T>{

    int hardCounter;

    public BinarySearch() {
        hardCounter = 0;
    }

    @Override
    public int search(T[] array, T key) {
        int left = 0, right = array.length;
        while (right - left > 1){
            int mid = (left + right) / 2;
            hardCounter++;
            if(array[mid].compareTo(key) == 0){
                return mid;
            }
            if(array[mid].compareTo(key) < 0){
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch<Integer> search = new BinarySearch<>();
        Integer [] arr = new Integer[100000];
        Random r = new Random();
        for (int i = 0; i < 100000; i++) {
            arr[i] = r.nextInt(100);
        }
        System.out.println(search.search(arr, 7) + " " +
                search.hardCounter);

    }
}
