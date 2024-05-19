import java.util.ArrayDeque;
import java.util.Queue;

/*
전력망을 둘로 나누기
- 완전 탐색

문제
- n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어있음
- 전선들 중 하나를 끊어서 2개로 분할
- 송전탑의 개수 최대한 비슷하게

문제 해결 방법
1. 행렬로 그래프 표현
2. 전선을 하나씩 끊어서 전력망 분리
3. bfs로 전력망 중 하나 선택해서 연결된 노드 수 구하기
4. 최솟값 갱신
 */
public class PRG_86971 {
    static int[][] graph;

    static int solution(int n, int[][] wires) {
        // 송전탑 개수 차이
        int answer = n;
        graph = new int[n + 1][n + 1]; // 1부터 시작

        // 그래프 만들기
        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            // 양방향 그래프
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            // 하나씩 끊기
            graph[from][to] = 0;
            graph[to][from] = 0;

            // 송전탑 개수 차이 확인
            answer = Math.min(answer, bfs(n, from));

            // 원상복귀
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        return answer;
    }

    static int bfs(int n, int x) { // x : 시작점
        int cnt = 1; // 본인 송전탑 포함
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        visited[x] = true;
        queue.offer(x);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i <= n; i++) {
                // 아직 방문하지 않은 송전탑
                if (graph[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                    cnt++;
                }
            }
        }

        return Math.abs(cnt - (n - cnt));
    }

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }
}
