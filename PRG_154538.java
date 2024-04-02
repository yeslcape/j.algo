/*
숫자 변환하기
- bfs

조건
- x에 n을 더합니다
- x에 2를 곱합니다.
- x에 3을 곱합니다.

bfs로 x + n | x * 2 | x * 3 경우 탐색
제일 빨리 y에 도달하면 종료
 */

import java.util.ArrayDeque;
import java.util.Queue;

// bfs
public class PRG_154538 {

    static class Number{
        int current;
        int depth;

        Number(int current, int depth) {
            this.current = current;
            this.depth = depth;
        }
    }

    public static int solution(int x, int y, int n) {
        if (x == y)
            return 0; // 0 출력

        return bfs(x, y, n);
    }

    static int bfs(int x, int y, int n) {
        Queue<Number> q = new ArrayDeque<>();
        q.offer(new Number(y, 0));

        while (!q.isEmpty()) {
            Number cur = q.poll();
            if (cur.current == x) {
                return cur.depth;
            }

            if (cur.current - n >= x)
                q.offer(new Number(cur.current - n, cur.depth + 1));
            if (cur.current % 2 == 0 && cur.current / 2 >= x)
                q.offer(new Number(cur.current / 2, cur.depth + 1));
            if (cur.current % 3 == 0 && cur.current / 3 >= x)
                q.offer(new Number(cur.current / 3, cur.depth + 1));
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 40, 5));
        System.out.println(solution(10, 40, 30));
        System.out.println(solution(2, 5, 4));
    }
}