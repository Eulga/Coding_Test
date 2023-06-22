package example.sparta_test.상;


/**
 * 조건 1: 결과는 하나의 문자열이며, 2차원 배열의 요소들에 해당하는 문자는 길이 1의 공백으로 구분된다.
 * 조건 2: 결과에서 배열간의 구분은 줄바꿈으로 한다.
 * 조건 3: 사방의 수 중 가장 큰 수와 기준점의 수가 같을 경우 *표시를 하지 않는다.
 */
public class Main {

    // 상 하 좌 우 좌표 이동용 배열
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] check = new boolean[5][5]; // 가장 큰 수 위치 지정

    public void solution(int[][] arr1) {
        // 배열 전체 확인
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                check(i, j, arr1);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (check[i][j]) sb.append("*");
                else sb.append(arr1[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void check(int nx, int ny, int[][] arr) {
        int max = 0;
        int sideNumber;

        for (int i = 0; i < 4; i++) {
            int mx = nx+dx[i];
            int my = ny+dy[i];

            // 배열 범위를 벗어난 수 차단
            // (ArrayIndexOutOfBoundsException 방지)
            if (mx < 0 ||  my < 0 || mx >= arr.length || my >= arr.length) continue;

            // 상 하 좌 우 값
            sideNumber = arr[mx][my];
            max = Math.max(sideNumber, max);
        }
        if (arr[nx][ny] > max) check[nx][ny] = true;
    }

    public static void main(String[] args) {
        Main method = new Main();
        int[][] arr1 = {{7,4,6,5,9}, {6,1,3,4,5}, {4,8,5,6,9}, {1,3,0,6,4}, {6,4,8,1,7}};

        method.solution(arr1);
    }
}
