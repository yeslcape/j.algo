/*
숫자 카드 나누기
1. arrayA 모든 숫자 나눌 수 있음 / arrayB 모든 숫자 나눌 수 없음
2. arrayA 모든 숫자 나눌 수 없음 / arrayB 모든 숫자 나눌 수 있음
 */

public class PRG_135807 {
    static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0]; // 최대공약수
        int gcdB = arrayB[0]; // 최대공약수

        for (int i = 0; i < arrayA.length; i++) {
            // arrayA의 최대공약수 구하기
            gcdA = gcd(gcdA, arrayA[i]);
            // arrayB의 최대공약수 구하기
            gcdB = gcd(gcdB, arrayB[i]);
        }

        // 서로꺼 나눌 수 있는지 확인하기
        if (!divisible(arrayA, gcdB)) {
            if (answer < gcdB) answer = gcdB;
        }

        if (!divisible(arrayB, gcdA)) {
            if (answer < gcdA) answer = gcdA;
        }

        return answer;
    }

    static int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a% b);
    }

    static boolean divisible(int[] array, int gcd) {
        for (int a: array) {
            if (a % gcd == 0) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 17}, new int[]{5, 20}));
        System.out.println(solution(new int[]{10, 20}, new int[]{5, 17}));
        System.out.println(solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
    }
}
