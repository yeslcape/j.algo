/*
연속된 부분 수열의 합
- 기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열
- 부분 수열의 합 : k
- 합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열 return
- 길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열 return
 */

import java.util.Arrays;

public class PRG_178870 {
    static int[] solution(int[] sequence, int k) {
        int N = sequence.length;
        int left = 0, right = N;
        int sum = 0;
        for(int L = 0, R = 0; L < N; L++) {
            while(R < N && sum < k) {
                sum += sequence[R++];
            }

            if(sum == k) {
                int range = R - L - 1;
                if((right - left) > range) {
                    left = L;
                    right = R - 1;
                }
            }

            sum -= sequence[L];
        }

        return new int[]{left, right};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
        System.out.println(Arrays.toString(solution(new int[]{2, 2, 2, 2, 2}, 6)));
    }
}
