/*
게임 맵 최단거리
- bfs : queue 사용
bfs 사용 이유 : 가장 빠른 거리 찾기
도착 못하는 조건 : 상대 팀 진영 주위에 벽을 세워두었다면 도착 불가
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class PRG_1844 {

    static int solution(int[][] maps) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        queue.offer(new int[] {0, 0, 1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            // queue poll
            int[] cur = queue.poll();

            // 탈출 조건
            if(cur[0] == maps.length - 1 && cur[1] == maps[0].length - 1) return cur[2];

            // 다음 찾기
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int next = cur[2] + 1;

                // 이동 불가
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) continue;
                if (visited[nx][ny]) continue;
                if (maps[nx][ny] == 0) continue;

                // queue에 넣기 : 이동
                queue.offer(new int[]{nx, ny, next});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }
}
