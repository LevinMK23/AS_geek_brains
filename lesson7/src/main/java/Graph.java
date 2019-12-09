import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Graph {

    //Функция должна вернуть количество
    //    // знакомых у самого популярного человека
    //    //знакомые это друзья и друзья друзей в глубину
    //до бесконечности)))
    //самый популярный человек - это человек у
    //которого больше всего знакомых
    static int friendCounter(Scanner in){
        int n = in.nextInt(); // количество людей
        int m = in.nextInt();//количество пар связей
        //далее следуют м пар значений
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = in.nextInt(), to = in.nextInt();
            g.get(from).add(to);
            g.get(to).add(from);
        }
        boolean [] used = new boolean[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                dfs(g, i, used);
                ans = max(ans, friendsCounter);
                friendsCounter = 0;
            }
        }
        return 0;
    }

    static int friendsCounter = 0;

    static void dfs(ArrayList<ArrayList<Integer>> g, int v, boolean [] used){
        if (!used[v]){
            friendsCounter++;
            used[v] = true;
            for (Integer i : g.get(v)) {
                dfs(g, i, used);
            }
        }
    }

    static int minDis = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int [][] m = new int[][] {{100000, 15, 1, 7},
                {15, 1000000, 4, 9},
                {1, 4, 1000000, 2},
                {7, 9, 2, 1000000}};
        int [] a = new int[5];
        a[0] = a[4] = 1;
        perm(a, 1, 4, new boolean[5], m);
    }

    static int [] ans;

    private static void perm(int [] a, int idx, int n, boolean [] used,
                             int [][] m) {
        if (idx == n) {
            //1 2 3 4 1
            int dis = 0;
            for (int i = 0; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
            for (int i = 0; i < n; i++) {
                dis += m[a[i]-1][a[i + 1]-1];
            }
            System.out.println(dis);
            //minDis = min(minDis, dis);
            if (dis < minDis){
                minDis = dis;
                ans = Arrays.copyOf(a, a.length);
            }

        } else {
            for (int i = 2; i <= n; i++) {
                if (!used[i]) {
                    a[idx] = i;
                    used[i] = true;
                    perm(a, idx + 1, n, used, m);
                    used[i] = false;
                }
            }
        }
    }

    static int travelingSalesman(Scanner in){
        int n = in.nextInt();
        int [][] m = new int[n][n];//matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = in.nextInt();
            }
        }
        int [] a = new int[n + 1];
        a[0] = 1; a[n] = 1;
        perm(a, 1, n, new boolean[n+1], m);
        return minDis;
    }

    //вернуть путь с минимальным вторым городом
    //путь должен состоять из n чисел
    static int [] travelingSalesmanWay(Scanner in){
            int n = in.nextInt();
            int [][] m = new int[n][n];//matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = in.nextInt();
                }
            }
        int [] a = new int[n + 1];
        a[0] = 1; a[n] = 1;
        perm(a, 1, n, new boolean[n+1], m);
        return ans;
    }
}
