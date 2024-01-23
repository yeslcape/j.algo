/*
1. K진수로 변환 : 반복문 돌면서 수를 K로 나눈 나머지를 문자열로 저장 -> reverse
2. 0을 기준으로 자르기 : split 사용 - 00의 경우, 중간에 ""으로 문자열 저장됨
3. 소수 개수 구하기 : 0 또는 1이면 false, 2 이상의 값으로 숫자가 나누어지면 false
!! int로 하면 런타임에러 발생 !!
*/
public class PRG_92335 {
    static boolean isPrime(long n) {
        if (n == 0 || n == 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    static int solution(int n, int k) {
        // K진수로 변환
        String number = "";
        while(n >= 1) {
            number += n % k;
            n /= k;
        }
        number = new StringBuilder(number).reverse().toString();

        // 0을 기준으로 자르기
        String[] arr = number.split("0");

        // 소수 개수 구하기
        int answer = 0;
        for (String a: arr) {
            if (!a.isEmpty() && isPrime(Long.parseLong(a))) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
    }
}
