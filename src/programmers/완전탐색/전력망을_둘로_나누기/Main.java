package programmers.완전탐색.전력망을_둘로_나누기;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }
}

// wires 안에 연결 정보를 하나씩 뺀 후 dfs 측정
// 하나씩 빼서 돌리면 무조건 두개의 크기정보가 나오고 그겨 비교해서 answer와 크기비교
class Solution {
    private int n;
    boolean[] visited;
    boolean[][] arr;
    int count;

    public int solution(int n, int[][] wires) {
        this.n = n;
        int answer = n;

        for (int i = 0; i < wires.length; i++) {
            visited = new boolean[n + 1];
            arr = new boolean[n + 1][n + 1];
            for (int k = 0; k < wires.length; k++) {
                if (k == i) continue;

                int a = wires[k][0];
                int b = wires[k][1];

                arr[a][b] = arr[b][a] = true;
            }
            count = 0;
            dfs(1);
            int result = Math.abs(count * 2 - n);

            answer = Math.min(answer, result);
        }

        return answer;
    }

    public void dfs(int start) {
        visited[start] = true;
        count++;

        for (int i = 1; i <= n; i++) {
            if (arr[start][i] && !visited[i]) {
                dfs(i);
            }
        }
    }
}