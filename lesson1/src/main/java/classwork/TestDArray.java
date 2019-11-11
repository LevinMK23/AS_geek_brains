package classwork;

public class TestDArray {
    public static void main(String[] args) {
        DArray<String> arr = new DArray<>();
        for (int i = 0; i < 10; i++) {
            arr.add("" + i);
        }
        arr.set(5, "12");
        arr.show();
    }
}
