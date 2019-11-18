package Stack;

public interface LIFO<T> extends Iterable<T>{
    int size();
    T pop();
    T peek();
    void push(T value);
    void show();
}
