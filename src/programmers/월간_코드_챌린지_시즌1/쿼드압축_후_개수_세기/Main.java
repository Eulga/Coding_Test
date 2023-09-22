package programmers.월간_코드_챌린지_시즌1.쿼드압축_후_개수_세기;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]
                {
                        {1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {0, 1, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 1},
                        {0, 0, 0, 0, 1, 1, 1, 1}
                });
    }
}

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {};
        return answer;
    }
}