/*
주식가격
- 이중 for 문 : 완전 탐색
1. 초 단위로 기록된 주식 가격 배열 탐색
2. 다음 초부터 마지막초까지 비교
- 가격이 떨어졌을 경우, 해당 초를 정답 배열에 저장
- 가격이 안 떨어졌을 경우, 배열 길이 - 1 에서 해당 초 빼기
 */

public class PRG_42584 {
    static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int p = 0; p < prices.length - 1; p++) { // 초 단위로 기록된 주식 가격
            for (int q = p + 1; q < prices.length; q++) {
                if (prices[p] > prices[q]) { // 이전 초의 주식가격이 더 높으면
                    answer[p] = q - p; // 몇 초 걸렸는지
                    break;
                }
            }
            if (answer[p] == 0) answer[p] = prices.length - 1 - p; // 가격이 안 떨어졌을 경우
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(new int[]{1, 2, 3, 2, 3});
        for (int a: answer) {
            System.out.print(a + " ");
        }
    }
}
