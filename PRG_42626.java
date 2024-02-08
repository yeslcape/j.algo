/*
더 맵게
- 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
1. 우선순위 큐에 모든 음식 넣기 -> 작은 수부터 정렬
2. 반복문
 2-1. 가장 맵지 않은 음식의 스코빌 지수, 두번째로 맵지 않은 음식의 스코빌 지수 꺼내기
 2-2. 두 음식의 스코빌 지수 계산해서 다시 큐에 넣기 + 섞음 횟수 증가
 2-3. 탈출 조건
      - 섞은 음식의 스코빌 지수가 나왔을 때
      - 우선순위 큐 사이즈가 1 이하이면, 계산 불가로 인한 break
3. 결과 : 섞음 횟수
 */

import java.util.PriorityQueue;
public class PRG_42626 {
    static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int sco: scoville) {
            pq.add(sco);
        }

        while (pq.peek() < K) {
            // pq 정렬 - 제일 작은 거가 앞
            if (pq.size() <= 1) {
                return -1;
            }
            int one = pq.poll();
            int two = pq.poll();
            int result = one + two * 2;
            pq.add(result);
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
