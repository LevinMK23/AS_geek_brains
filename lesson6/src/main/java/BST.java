import java.util.Comparator;

public class BST<T extends Comparable<T>> implements Tree<T>{

    private int size;
    private Node<T> root;
    private Comparator<T> comp;

    private class Node<T> {
        T value;
        Node<T> l, r;

        public Node(T value) {
            this.value = value;
            l = r = null;
        }
    }

    public BST() {
        size = 0;
        root = null;
    }

    @Override
    public void add(T element) {
        if (root == null){
            root = new Node<>(element);
        } else {
            add(root, element);
        }
        size++;
    }

    //O(logN)
    private void add(Node<T> node, T element){
        if (node.value.compareTo(element) > 0){
            if (node.l == null){
                node.l = new Node<>(element);
            }else {
                add(node.l, element);
            }
        }
        if (node.value.compareTo(element) < 0){
            if (node.r == null){
                node.r = new Node<>(element);
            } else {
                add(node.r, element);
            }
        }
    }

    @Override
    public void remove(T element) {

    }

    //O(logN)
    private boolean find(Node<T> node, T value){
        if (node == null) {
            return false;
        }
        if (value.compareTo(node.value) == 0) {
            return true;
        }
        if (value.compareTo(node.value) < 0){
            return find(node.l, value);
        } else {
            return find(node.r, value);
        }
    }

    @Override
    public boolean find(T element) {
        return find(root, element);
    }

    static StringBuilder str;

    @Override
    public String preOrder() {

        return str.toString();
    }

    public void showPreOrder(){
        preOrder(root);
    }

    //O(N)
    private void preOrder(Node<T> node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.l);
            preOrder(node.r);
        }
    }

    @Override
    public String inOrder() {

        return str.toString();
    }

    public void showTree(){
        inOrder(root);
    }

    private void inOrder(Node<T> node) {
        if (node != null){
            inOrder(node.l);
            System.out.print(node.value + " ");
            inOrder(node.r);
        }
    }

    @Override
    public String postOrder() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
