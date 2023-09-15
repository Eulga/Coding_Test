package programmers.KAKAO_BLIND_RECRUITMENT_2018.n진수게임_3차;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(16, 16, 2, 1));
    }

}

// 실수한 부분
// remainder 5명 중 2,3,4 번째의 경우를 생각하지 않았음
// remainder = [p == 1 ? 1 : 0] -> [p == 1 ? 1 : p == m ? 0 : p]
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int remainder = p == 1 ? 1 : p == m ? 0 : p; // 나눗셈의 나머지
        int maxSize = t * m; // result의 최대 크기

        int count = 0; // sb의 길이가 t가 될 때까지 증가할 수
        while (sb.length() < maxSize) {
            sb.append(Integer.toString(count, n));
            count++;
        }

        StringBuilder answer = new StringBuilder();
        char[] result = sb.toString().toCharArray();

//        for (int i = 0; i < result.length; i++) {
//            if ((i + 1) % m == remainder) answer.append(result[i]);
//            if (answer.length() == t) break;
//        }

        // 위 반복문 최적화 ( 다른사람 답변 참고함 )
        for (int k = 0; k < t; k++) {
            answer.append(sb.toString().charAt(p - 1 + k * m));
        }

        return answer.toString().toUpperCase();
    }
}
