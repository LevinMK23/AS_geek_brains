package classWork;

import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    int hardCounter = 0;

    @Override
    public void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                hardCounter++;
                if(arr[j].compareTo(arr[j+1]) > 0){
                    T tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer [] arr = {10,9,8,7,6,5,4,3,2,1};
        BubbleSort<Integer> s = new BubbleSort<>();
        s.sort(arr);
        System.out.println(s.hardCounter);
        System.out.println(Arrays.toString(arr));
    }
}
