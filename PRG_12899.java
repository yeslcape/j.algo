/*
124 나라의 숫자
 */
public class PRG_12899 {
    static String solution(int n) {
        // String으로 하면 효율성 오류 발생
        StringBuilder result = new StringBuilder();
        int[] numbers = {1, 2, 4};

        while (n > 0) {
            n--;
            result.insert(0, numbers[n % 3]);
            n /= 3;
        }

        return result.toString();
    }

    /*
    String[] onetwofour = {"1", "2", "4"};
    public String solution(int n) {
        if (n <= 3) return onetwofour[n - 1];
        else {
            int q = (n - 1) / 3;
            int r = (n - 1) % 3;
            return solution(q) + onetwofour[r];
        }
    }
     */

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
    }
}
