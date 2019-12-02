import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.add(5);
        tree.add(1);
        tree.add(7);
        tree.add(12);
        tree.add(-3);
        for (int i = 0; i < 13; i++) {
            System.out.println(i + " " + tree.find(i));
        }
        tree.showTree();
        System.out.println();
        tree.showPreOrder();
    }
}
