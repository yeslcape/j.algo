/*
2 x n 타일링
- dynamic programming

2 x 1 : 1
2 x 2 : 2
2 x 3 : 3
2 x 4 : 5

 dp[n] = dp[n - 1] + dp[n - 2]
 */
public class PRG_12900 {
    static int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
