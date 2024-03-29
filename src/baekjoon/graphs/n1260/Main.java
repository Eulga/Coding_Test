package baekjoon.graphs.n1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static boolean[][] arr;

    static int node, line, start;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new boolean[node+1][node+1];
        check = new boolean[node+1];

        for (int i = 0; i < line; i++) {
            StringTokenizer strt = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(strt.nextToken());
            int b = Integer.parseInt(strt.nextToken());

            arr[a][b] = arr[b][a] = true;
        }
        dfs(start);
        sb.append("\n");
        check = new boolean[node+1];

        bfs(start);

        System.out.println(sb);
    }

    public static void dfs(int start) {
        check[start] = true;
        sb.append(start).append(" ");

        for (int i = 1; i <= node; i++) {
            if(arr[start][i] && !check[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {
            start = q.poll();
            sb.append(start).append(" ");

            for (int i = 1; i <= node; i++) {
                if(arr[start][i] && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
