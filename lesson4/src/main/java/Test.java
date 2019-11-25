import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(0, i+1);
        }
        for (int i = 0; i < 10; i++) {
            list.add(3, i+1);
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            Integer obj = it.next();
            if (obj == 4 || obj == 7) {
                it.remove();
            }
            System.out.println(obj);
        }
        for(Integer i : list) System.out.print(i + " ");
    }
}
