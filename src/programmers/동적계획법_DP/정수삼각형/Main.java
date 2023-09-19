package programmers.동적계획법_DP.정수삼각형;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}

// dfs로 트라이 했지만 시간초과(효율성)
// 역순으로 올라가는 식으로 생각하다가 비교해서 더하기 연산을 줄여보자 생각함
// Math.max 보다 직접 비교하는게 결과가 조금 더 빨랐음
class Solution {
    public int solution(int[][] triangle) {
        int[] arr = new int[triangle.length];

        for (int i = triangle.length - 1; i > 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                arr[j] += triangle[i][j];
            }
            for (int j = 0; j < triangle[i].length-1; j++) {
                arr[j] = arr[j] > arr[j+1] ? arr[j] : arr[j+1];
            }
        }

        return arr[0]+triangle[0][0];
    }
}
