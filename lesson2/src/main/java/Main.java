import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArray<Integer> arr = new MyArray<>();
        for (int i = 0; i < 10; i++) {
            arr.add(new Random().nextInt(1000));
        }
        arr.show();
        arr.sort(Comparator.comparingInt(o -> o));
        //ArrayUtility.sort(arr);
        //ArrayUtility.insertSort(arr);
        //ArrayUtility.selectSort(arr);
        arr.show();
        arr.add(1, 55);
        arr.show();
        arr.remove(7);
        arr.show();

        System.out.println(ArrayUtility.binarySearch(arr, 3));
        System.out.println(ArrayUtility.linearSearch(arr, 3));



    }
}
