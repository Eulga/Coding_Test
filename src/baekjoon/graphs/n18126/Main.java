package baekjoon.graphs.n18126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static long max = 0;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        if(N == 1) {
            System.out.println(0);
            return;
        }

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==b) continue;

            arr[a][b] = c;
            arr[b][a] = c;
        }

        graph(1, 0);

        System.out.println(max);
    }

    static void graph(int n, long sum) {
        if(visited[n]) return;

        visited[n] = true;
        max = Math.max(max, sum);

        for (int i = 1; i <= N; i++){
            int num = arr[n][i];
            if(num > 0) graph(i, sum + num);
        }

        visited[n] = false;
    }
}
