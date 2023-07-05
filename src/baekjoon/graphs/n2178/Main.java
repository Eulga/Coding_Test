package baekjoon.graphs.n2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] check;
    static int[][] arr;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N][M];
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line[j] - 48;
            }
        }

        check[0][0] = true;
        bfs(0, 0);
        System.out.println(arr[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int mx = nowX + dx[i];
                int my = nowY + dy[i];

                if (mx < 0 || my < 0 || mx >= N || my >= M) continue;
                if (check[mx][my] || arr[mx][my] == 0) continue;

                q.add(new int[]{mx, my});
                arr[mx][my] = arr[nowX][nowY] + 1;
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        System.out.print(arr[j][k]+" ");
                    }
                    System.out.println();
                }
                System.out.println();
                check[mx][my] = true;
            }
        }
    }
}