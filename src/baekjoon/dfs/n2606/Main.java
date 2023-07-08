package baekjoon.dfs.n2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] check;
    static boolean[][] computers;

    static int numberOfComputers, pair, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numberOfComputers = Integer.parseInt(br.readLine());
        pair = Integer.parseInt(br.readLine());
        check = new boolean[numberOfComputers+1];

        computers = new boolean[numberOfComputers + 1][numberOfComputers + 1];
        for (int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computers[a][b] = computers[b][a] = true;
        }

        count = 0;
        dfs(1);

        System.out.println(count);
    }

    private static void dfs(int start) {
        check[start] = true;

        for (int i = 1; i <= numberOfComputers; i++) {
            if (computers[start][i] && !check[i]) {
                count++;
                dfs(i);
            }
        }
    }
}
