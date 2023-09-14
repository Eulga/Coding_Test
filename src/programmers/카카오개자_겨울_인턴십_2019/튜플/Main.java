package programmers.카카오개자_겨울_인턴십_2019.튜플;

import java.util.*;

// contains를 쓰니까 List로 하던 뭘로 하던 상관이 없었던 것 같음
// Set에 add가 boolean을 뱉어 내기때문에 Set을 이용해도 되는 것 같음
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Arrays.stream(solution.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")).forEach(System.out::print);
    }
}

class Solution {
    public int[] solution(String s) {
        s = s.replace("{", "");
        s = s.replace("}}", "");
        String[] strings = s.split("},");

        int[] answer = new int[strings.length];
        Queue<String> queue = new LinkedList<>();

        Arrays.stream(strings).sorted(Comparator.comparing(String::length)).forEach(str -> {
            for(String str1: str.split(",")) {
                if(!queue.contains(str1)) queue.add(str1);
            }
        });
        for (int i = 0 ; i < answer.length; i++) {
            answer[i] = Integer.parseInt(queue.poll());
        }
        return answer;
    }
}
