package classwork;

public class DArray<T> {

    private int size, capacity;
    private Object [] data;

    public DArray() {
        size = 0;
        capacity = 128;
        data = new Object[capacity];
    }

    private void reallocate(){
        System.err.println("array was reallocated " + capacity);
        capacity *= 2;
        Object [] tmp = new Object[capacity];
        // N
        if (size >= 0) {
            System.arraycopy(data, 0,
                    tmp, 0, size);
        }
        data = tmp;
    }

    public void add(T value){
        if(size < capacity) {
            data[size] = value;
            size++;
        } else {
            reallocate();
            data[size] = value;
            size++;
        }
    }

    public void add(int index, T value){
        //TODO
    }

    public void remove(int index){
        //TODO

        System.out.println("Хахаха вот моя домашка");
    }

    @Override
    public String toString() {
        //TODO
        //String like [1, 2, 3, 4, 5]
        return null;
    }

    public void show(){
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public int size(){
        return size;
    }

    public void set(int index, T value){
        data[index] = value;
    }

    public T get(int index){
        return (T) data[index];
    }
}
