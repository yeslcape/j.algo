/*
[PCCP 기출문제] 2번 / 석유 시추
- 시추관 열에 하나 두면, 연결되어있는 모든 석유 뽑을 수 있음

1. bfs로 석유량 구하기 : 이 때 시작점과 끝 열을 구해서 1차원 배열(column)에 저장
    - 여러 개면 += 하기
2. 1차원 배열 돌면서 최댓값 return
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class PRG_250136 {
    static int solution(int[][] land) {
        int[] column = new int[land[0].length];
        boolean[][] visited = new boolean[land.length][land[0].length];

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (visited[i][j]) continue;
                if (land[i][j] == 0) continue;

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                Queue<int[]> queue = new ArrayDeque<>();
                queue.offer(new int[] {i, j});
                visited[i][j] = true;

                int cnt = 0;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    cnt++;

                    if (min > cur[1]) min = cur[1];
                    if (max < cur[1]) max = cur[1];

                    for (int k = 0; k < 4; k++) {
                        int nx = cur[0] + dx[k];
                        int ny = cur[1] + dy[k];

                        if (nx < 0 || ny < 0 || nx >= land.length || ny >= land[0].length) {
                            continue;
                        }

                        if (visited[nx][ny] || land[nx][ny] == 0) {
                            continue;
                        }

                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }

                for (int k = min; k <= max; k++) {
                    column[k] += cnt;
                }
            }
        }

        int result = 0;
        for (int j : column) {
            if (result < j) result = j;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}}));
    }
}
