/*
2개 이하로 다른 비트
- 비트연산
- 그리디

1. 짝수일 경우 : + 1
  - 짝수면, 비트 끝이 0이기 때문
2. 홀수일 경우 : 0이 나올 때, 01을 10 비트로 변경
  - 최소값을 찾기 위해서, 0을 1로만 바꾸는 것보다 01을 10으로 바꾸는 게 더 작음
 */

import java.util.Arrays;

public class PRG_77885 {
    static long[] solution(int[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                int idx = binary.lastIndexOf("0");

                if (idx == -1) {
                    String chg = "10" + binary.substring(1);
                    answer[i] = Long.parseLong(chg, 2);
                } else {
                    String chg = binary.substring(0, idx) + "10" + binary.substring(idx + 2);
                    answer[i] = Long.parseLong(chg, 2);
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 7})));
    }
}
