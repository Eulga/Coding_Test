package programmers.연습문제.하노이의탑;

// T(n) == 2^n - 1 == n개의 원판이 최소한의 이동으로 3번까지 가는 횟수
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(2);
    }
}

class Solution {
    int[][] answer;
    int count;

    public int[][] solution(int n) {
        answer = new int[(int) Math.pow(2, n) - 1][2];
        count = 0;
        hanoi(n, 1, 3, 2);
        return answer;
    }

    public void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            answer[count] = new int[]{from, to};
            count++;
            return;
        }

        // n-1개의 원반을 via 기둥으로 이동
        hanoi(n - 1, from, via, to);

        // 가장 큰 원반을 to 기둥으로 이동
        answer[count] = new int[]{from, to};
        count++;

        // n-1개의 원반을 to 기둥으로 이동
        hanoi(n - 1, via, to, from);
    }
}
