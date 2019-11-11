
import java.lang.Object;
import java.util.Comparator;

public class MyArray<T> {

    private Object[] data;
    private int size, capacity, q;

    public MyArray() {
        size = 0;
        capacity = 1000;
        data = new Integer[capacity];
    }

    void getQ(){
        System.out.println(q);
    }

    void show(){
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    //вставка в конец массива
    void add(T element){
        if(size < capacity){
            data[size] = element;
            size++;
        }
        else {
            reallocate();
            data[size] = element;
            size++;
        }
    }

    void set(int index, T value){
        data[index] = value;
    }

    T get(int index){
        return null;
    }

    int size(){
        return size;
    }

    //вставка по индексу
    void add(int index, T element){
        //TODO
    }

    //перевыделение памяти можно увеличить вместимость
    //на константу либо в константное количество раз
    //подумайте как лучше
    private void reallocate(){
        capacity *= 2;
        Integer[] tmp = new Integer[capacity];
        if (size >= 0) System.arraycopy(data, 0, tmp, 0, size);
        data = tmp;
    }

    //удаление последнего
    boolean remove(){
        size--;
        return false;
    }
    //удаление по индексу
    boolean remove(int index){
        //TODO
        return false;
    }

    T [] toArray(){
        //TODO
        return null;
    }

    void sort(){
        //TODO
    }

    private void qs(T [] data, int left, int right) {
        //TODO
    }

}
