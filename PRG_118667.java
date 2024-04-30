/*
두 큐 합 같게 만들기
- 큐

1. 큐 별로 합 변수 선언, 현재 큐 합만큼 변수 값 지정
2. 큐가 더 큰 거에서 pop
    - 큐 pop 하면 다른 변수 +
3. 같으면 break
4. 마지막까지 안 같으면 -1 (큐 크기보다 횟수가 크면)
*/

import java.util.ArrayDeque;
import java.util.Queue;

public class PRG_118667 {
    static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        long cntQ1 = 0;
        long cntQ2 = 0;

        // 큐 초기화
        for (int i: queue1) {
            cntQ1 += i;
            q1.offer(i);
        }
        for (int i: queue2) {
            cntQ2 += i;
            q2.offer(i);
        }

        if ((cntQ1 + cntQ2) % 2 == 1) return -1;

        int answer = 0;
        while(cntQ1 != cntQ2) { // 같지 않을 때까지
            answer++;

            if (cntQ1 > cntQ2) {
                int temp = q1.poll();
                cntQ1 -= temp;
                cntQ2 += temp;
                q2.offer(temp);
            } else {
                int temp = q2.poll();
                cntQ2 -= temp;
                cntQ1 += temp;
                q1.offer(temp);
            }

            if (answer > 600000) return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println(solution(new int[]{1, 1}, new int[]{1, 5}));
    }
}
