package programmers.월간_코드_챌린지_시즌1.삼각_달팽이;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Arrays.stream(solution.solution(5)).forEach(System.out::print);
    }
}

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int x = -1, y = 0, mx = 1, my = 0;
        int count = 1;
        int dir = 0; // 0 아래, 1 오른쪽, 2 대각선 왼쪽 위
        while(true) {
            for(int i = 0; i < n; i++) {
                x += mx;
                y += my;
                arr[x][y] = count++;
            }
            n--;
            if (n == 0) break;
            switch (dir) {
                case 0:
                    dir = 1;
                    mx = 0;
                    my = 1;
                    break;
                case 1:
                    dir = 2;
                    mx = -1;
                    my = -1;
                    break;
                case 2:
                    dir = 0;
                    mx = 1;
                    my = 0;
                    break;
            }
        }

        int[] answer = new int[count-1];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) answer[k++] = arr[i][j];
            }
        }
        return answer;
    }
}
