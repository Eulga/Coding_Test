package baekjoon.graphs.n4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dh = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dw = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(true) {
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(w == 0 || h == 0) break;

            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];
            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        count += dfs(map, visited, i, j);
                    }
                }
            }
            System.out.println(count);
            st = new StringTokenizer(br.readLine());
        }
    }

    private static int dfs(int[][] map, boolean[][] visited, int h, int w) {
        if(visited[h][w] || map[h][w] == 0) return 0;
        visited[h][w] = true;

        int mh;
        int mw;
        for (int i = 0; i < 8; i++) {
            mh = h + dh[i];
            mw = w + dw[i];
            if (mw < 0 || mh < 0 || mw >= map[0].length || mh >= map.length) continue;
            if (map[mh][mw] == 1) dfs(map, visited, mh, mw);
        }

        return 1;
    }
}