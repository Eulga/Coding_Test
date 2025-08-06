package baekjoon.greedy.n2437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int max;
    static boolean[] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        arr  = new int[N];

        st =  new StringTokenizer(br.readLine());
        max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
        }

        arr2 = new boolean[max+1];

        f1(0, 0);

        for (int i = 1; i < max; i++) {
            if (!arr2[i]) {
                System.out.print(i);
                return;
            }
        }
    }
    static void f1 (int i, int num) {
        if (i >= arr.length) return;

        for (int j = i; j < arr.length; j++) {
            int sum = num + arr[j];
            arr2[sum] = true;
            f1(j + 1, sum);
        }
    }
}
