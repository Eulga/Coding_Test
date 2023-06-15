package example.map;

import java.util.*;

/*
maps에 담긴 지도정보를 보고 동서남북으로만 이어진 섬을 파악하고 섬의 크기를 저장하는 배열을 오름차순하여 반환
섬(1) 바다(0)
중복값은 하나만 적용
ex) maps = {"111","001","000","100"}
*/

public class Main {
    static char[][] map;
    static boolean[][] v;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int cnt;

    public static void main(String[] args) {
        String[] maps = {"111", "001", "000", "100"};

        int col = maps[0].length();
        int row = maps.length;

        map = new char[row][col];
        v = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            map[i] = maps[i].toCharArray();
        }

        TreeSet<Integer> answerSet = new TreeSet<>();

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (v[i][k] || map[i][k] == '0') continue;
                dfs(i, k, col, row);
                answerSet.add(cnt);
                cnt = 0;
            }
        }
    }

    public static void dfs(int i, int k, int col, int row) {
        v[i][k] = true;
        if (map[i][k] == '1') {
            cnt++;
        }
        for (int l = 0; l < 4; l++) {
            int ny = i + dy[l];
            int nx = k + dx[l];

            if (ny < 0 || ny >= row || nx < 0 || nx >= col || v[ny][nx] || map[i][k] == '0') continue;

            dfs(ny, nx, col, row);
        }
    }
}