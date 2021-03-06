
import java.lang.Object;
import java.util.Arrays;
import java.util.Comparator;

public class MyArray<T extends Comparable<T>> {

    private Object[] data;
    private int size, capacity;

    public MyArray() {
        size = 0;
        capacity = 128;
        data = new Object[capacity];
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void add(T element) {
        if (size >= capacity) {
            reallocate();
        }
        data[size] = element;
        size++;
    }

    public void set(int index, T value) {
        data[index] = value;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public int size() {
        return size;
    }

    public void add(int index, T element) {
        if (size >= capacity) {
            reallocate();
        }
        if (size - index >= 0) {
            System.arraycopy(data, index, data,
                    index + 1, size - index);
        }
        data[index] = element;
        size++;
    }

    private void reallocate() {
        capacity *= 2;
        Object[] tmp = new Object[capacity];
        if (size >= 0) System.arraycopy(data, 0, tmp,
                0, size);
        data = tmp;
    }

    public boolean remove() {
        size--;
        return size >= 0;
    }

    public boolean remove(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("index = " + index);
        }
        if (size - 1 - index >= 0) {
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
        }
        size--;
        return true;
    }

    /*
     * Метод должен возвращать массив размером size
     * */
    public T[] toArray() {
        //TODO
        Object[] tmp = new Object[size];
        System.arraycopy(data, 0, tmp, 0, size);
        return (T[]) tmp;
    }

    /*
     * Метод должен возвращать индекс первого найденного элемента
     * или -1, если такого нет
     * */
    public int linearSearch(T element) {
        for (int i = 0; i < size; i++) {
            if (((T) data[i]).compareTo(element) == 0) {
                return i;
            }
        }
        return -1;
    }

    /*
     * Тип data - Object, но для сортировки нам нужен сравнимый тип
     * мы именного его передаем внутрь
     * Поскольку класс Объект родитель всего
     * справедлива следующая запись: ((T)arrayElement).compareTo(T otherElement)
     * Объект приведенный к типу Т, будет иметь метод сравнения
     * */
    public void insertSort() {
        //TODO
    }

    static class Pair<T> {
        T element;
        Integer counter;

        public Pair(T element, Integer counter) {
            this.element = element;
            this.counter = counter;
        }
    }

    /*
     * Метод должен вернуть пару из значения элемента
     * и количества раз, которое он встретился в массиве data
     * вернуть нужно пару, элемент которой встретился наибольшее количество раз
     * А если таквых элементов много, то нужно вернуть тот, у которого значение наибольшее
     * Пусть data = [1, 3, 1, 5, 1, 4] тогда ответ new Pair<Integer>(1, 3)
     * Пусть data = [1, 2, 1, 2, 1, 2] тогда ответ new Pair<Integer>(2, 3)
     * Пусть data = [1, 2, 3, 4, 5, 6] тогда ответ new Pair<Integer>(6, 1)
     * Пусть data = [1, 1, 3, 4, 5, 6] тогда ответ new Pair<Integer>(1, 2)
     * */
    public Pair<T> taskMaxCount() {
        //TODO
        bubbleSort();
        int cnt = 1, max = 0;
        T element = null;
        for (int i = 0; i < size - 1; i++) {
            if (((T) data[i]).compareTo((T) data[i + 1]) == 0) {
                cnt++;
            } else {
                if (cnt >= max) {
                    max = cnt;
                    element = (T) data[i];
                }
                cnt = 1;
            }
        }
        return new Pair<>(element, cnt);
    }

    public void bubbleSort() {
        //TODO
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((T) data[j]).compareTo((T) data[j + 1]) > 0) {
                    T tmp = (T) data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }

    /*
     * Задача под звездочкой
     * решается опционально, кому интересно
     * O(NlogN)
     * */
    public void quickSort() {
        //TODO
    }

    private void quickSort(int left, int right) {
        //TODO
    }

    public static void main(String[] args) {
        MyArray<String> arr = new MyArray<>();
        for (int i = 0; i < 10; i++) {
            arr.add("i+1");
        }

        System.out.println(Arrays.toString(arr.toArray()));
    }

}
