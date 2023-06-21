package programmers.graph.방의개수;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

// 이 분의 코드를 카피했다. https://velog.io/@easycelsius/프로그래머스방의-개수
// 코드를 이해 했으나 응용 하여 수정할 코드를 찾지 못하여 원본을 적어 놓았다.

/**
 * 좌표 xy를 가지는 Pair 객체가 필요하고
 * map의 contains에 필요한 hashcode와 equlas를 오버리이딩 해서 재정의 해준다.
 * 재정의를 안해줄 경우 주소값으로 비교하게 된다. ( 이 경우 equals가 의도대로 동작하지 않게 된다. )
 * 대각선의 경우 문제의 그림처럼 진행할 경우 노드를 지나치지 않아 방 카운트를 하기 쉽지 않기 때문에
 * 2배 스케일업 해서 노드를 지나도록 만들어야한다.
 * key를 객체 value를 객체리스트로 만듦으로서 하나의 key는 최대 8개의 객체를 가진 리스트 value를 가질 수 있게 된다.
 * 시간복잡도와 공간복잡도는 아직 지식이 없어 해당 코드가 어떤식으로 복잡도를 조율했는지 알 수 없다.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0}));
    }

    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o) {
            return this.x == ((Pair) o).x && this.y == ((Pair) o).y;
        }
    }

    public static int solution(int[] arrows) {

        // 변수 선언
        int cnt = 0;

        // 방향 관련 배열 선언
        Pair pointHC = new Pair(0, 0);
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

        // 방문 여부 관련 선언
        // key = 시작 node의 hashcode, value = 연결된 node들의 hashcode
        HashMap<Pair, ArrayList<Pair>> visitied = new HashMap<>();

        visitied.put(pointHC, new ArrayList<Pair>());

        // 로직 처리
        for (int arrow : arrows) {
            for (int i = 0; i <= 1; i++) { // 교차점 처리를 위한 스케일업(반복 2번)
                // 이동 진행
                Pair newPointHC = new Pair(pointHC.x + dx[arrow], pointHC.y + dy[arrow]);

                // 처음 방문하는 경우 = map에 키값이 없는 경우
                if (!visitied.containsKey(newPointHC)) {
                    // 리스트에 연결점 추가
                    visitied.put(newPointHC, makeEdgeList(pointHC));
                    visitied.get(pointHC).add(newPointHC);

                    // 재방문했고 간선을 처음 통과하는 경우
                } else if (visitied.containsKey(newPointHC) && !(visitied.get(newPointHC).contains(pointHC))) {
                    visitied.get(newPointHC).add(pointHC);
                    visitied.get(pointHC).add(newPointHC);
                    cnt++;
                }

                // 이동 완료
                pointHC = newPointHC;
            }
        }

        return cnt;
    }

    // 밸류값에 넣기 위한 리스트 만들기
    public static ArrayList<Pair> makeEdgeList(Pair pointHC) {
        ArrayList<Pair> edge = new ArrayList<>();
        edge.add(pointHC);
        return edge;
    }
}
