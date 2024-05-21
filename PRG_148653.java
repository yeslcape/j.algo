/*
마법의 엘리베이터
- 구현
 */

public class PRG_148653 {
    static int solution(int storey) {
        int result = 0;

        while (storey != 0) {
            int one = storey % 10; // 나머지 값
            int ten = (storey / 10) % 10; // 10의 자리

            if (one > 5) { // 10에서 -1이 더 나음
                result += (10 - one); // -1 개수
                storey += 10;
            } else if (one == 5) { // 5
                // 10의 자리가 5이상이면 올림, 5미만이면 내림
                result += one;
                storey += (ten < 5 ? 0 : 10);
            } else {
                result += one;
            }

            storey /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution(2554));
    }
}
