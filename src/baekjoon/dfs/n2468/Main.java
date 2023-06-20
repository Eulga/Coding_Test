package baekjoon.dfs.n2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] check;
    static int[][] arr;

    static int[] direc = {1, -1, 1, -1};

    static int number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        number = Integer.parseInt(st.nextToken()); //배열크기

        check = new boolean[number][number];
        arr = new int[number][number];

        // 최대 높이 이상은 값이 동일할 것이기 때문에 최대 높이 저장
        int max_height = 0;
        for (int i = 0; i < number; i++) {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            for (int j = 0; j < number; j++) {
                int height = Integer.parseInt(stt.nextToken());
                max_height = Math.max(height, max_height);
                arr[i][j] = height;
            }
        }

        int result = 0;
        int max_result = 0;

        // 최대 높이 까지만 실행
        for (int k = 0; k <= max_height; k++) {
            for (int i = 0; i < number; i++) {
                for (int j = 0; j < number; j++) {
                    if (arr[i][j] > k && !check[i][j]) {
                        dfs(i, j, k);
                        result++;
                    }
                }
            }
            max_result = Math.max(result, max_result);
            check = new boolean[number][number];
            result = 0;
        }

        System.out.println(max_result);
    }

    public static void dfs(int n1, int n2, int rain) {
        check[n1][n2] = true;
        int move;

        for (int i = 0; i < 4; i++) {
            if (i < 2) {
                move = n2 + direc[i];
            } else {
                move = n1 + direc[i];
            }
            if (move < 0 || move >= number) continue;
            if (i < 2) {
                if (arr[n1][move] > rain && !check[n1][move]) dfs(n1, move, rain);
            } else {
                if (arr[move][n2] > rain && !check[move][n2]) dfs(move, n2, rain);
            }
        }
    }
}
