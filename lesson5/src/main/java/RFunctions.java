import javafx.util.Pair;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RFunctions {

    //функция должна находить число Фибоначчи с номер н
    BigInteger [] cash = new BigInteger[1001];

    BigInteger fib(int n){
        if (n == 1 || n == 2) return BigInteger.ONE;
        if (cash[n] != null){
            return cash[n];
        }
        cash[n] = fib(n-1).add(fib(n-2));
        return cash[n];
    }

    //функция должна считать факториал числа
    BigInteger factor(int n){
        return n == 0 ? BigInteger.ONE :
                factor(n - 1).multiply(BigInteger.valueOf(n));
    }

    //функция должна вводить числа из in до тех пор пока не будет введен 0
    //и вывести в out все числа в обратном порядке без 0
    void reverse(Scanner in, PrintWriter out){
        if (in.hasNext()){
            int x = in.nextInt();
            if (x == 0) return;
            reverse(in, out);
            out.println(x);
        }
    }

    //функция должна отсортировать массив слиянием

    List<Integer> mergeSort(List<Integer> list){
        if (list.size() <= 1) return list;
        Pair<List<Integer>, List<Integer>> p = split(list);
        return merge(mergeSort(p.getKey()),
                mergeSort(p.getValue()));
    }

    //функция должна разбить список пополам (2 2 для 4 или 3 2 для 5)
    Pair<List<Integer>, List<Integer>> split(List<Integer> list){
        int len = list.size() / 2 + list.size() % 2;
        ArrayList<Integer> a = new ArrayList<>(len + 1),
                b = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            a.add(list.get(i));
        }
        for (int i = len; i < list.size(); i++) {
            b.add(list.get(i));
        }
        return new Pair<>(a, b);
    }

    //функция должна вернуть отсортированный список, сливаемый из двух отсортированных
    List<Integer> merge(List<Integer> a, List<Integer> b){
        int i = 0, j = 0;
        if (a.isEmpty()) return b;
        if(b.isEmpty()) return a;
        ArrayList<Integer> m = new ArrayList<>(a.size() + b.size());
        while (true){
            if (a.get(i) < b.get(j)){
                m.add(a.get(i));
                i++;
                if (i == a.size() && j < b.size()){
                    while (j < b.size()){
                        m.add(b.get(j));
                        j++;
                    }
                    break;
                }
            } else {
                m.add(b.get(j));
                j++;
                if (j == b.size() && i < a.size()){
                    while (i < a.size()){
                        m.add(a.get(i));
                        i++;
                    }
                    break;
                }
            }
        }
        return m;
    }

    static boolean [] used;
    static int cnt = 0;
    //функция должна вернуть К-ую перестановку n-элементного множества
    //уникальных целых чисел дата
    int [] permutation(int [] data, int n, int k, int index, PrintWriter out){
        //TODO
        if(index == n){
            cnt++;
            if(cnt == k){
                out.println(Arrays.toString(data));
                return data;
            }
        }
        for (int i = 1; i <= n; i++) {
            if(used[i]) continue;
            data[index] = i;
            used[i] = true;
            permutation(data, n, k, index+1, out);
            used[i] = false;
        }
        return data;
    }

    //функция должна вернуть максимальную массу из предметов в дата, но не превышающую
    //лимит
    long knackPack(int [] data, long limit){
        return knackPack(data, limit, 0, 0);
    }

    private long knackPack(int [] data, long W, long sum, int index){
        if(W < 0) return Long.MIN_VALUE;
        if(index == data.length) return sum;
        return Math.max(knackPack(data, W - data[index], sum + data[index], index + 1),
                knackPack(data, W, sum, index + 1));
    }

    public static void main(String[] args) {
        List<Integer> a =  Arrays.asList(12, 4, 1, 7, 81, 18, 21);
        List<Integer> b = Arrays.asList(7, 12);
        System.out.println(new RFunctions().mergeSort(a));
    }

}
