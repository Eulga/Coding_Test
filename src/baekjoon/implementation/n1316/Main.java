package baekjoon.implementation.n1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            boolean check = true;
            Set<Character> set = new HashSet<>();
            Character pre = null;
            for (char spelling : br.readLine().toCharArray()) {
                if (pre == null) {
                    set.add(spelling);
                    pre = spelling;
                    continue;
                }
                if (spelling != pre) {
                    if (set.contains(spelling)) {
                        check = false;
                        break;
                    } else {
                        pre = spelling;
                        set.add(spelling);
                    }
                }
            }
            count = check ? count + 1 : count;
        }
        System.out.println(count);
    }
}
