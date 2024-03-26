/*
택배상자
- Stack
- 이유 : 한 방향으로만 진행 가능, 순서대로 상자 내림 (FILO)
 */

import java.util.Stack;

public class PRG_131704 {
    static int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();

        int idx = 0; // 순서 index

        for (int i = 1; i <= order.length; i++) {
            stack.add(i);
            while (stack.peek() == order[idx]) {
                idx++;
                stack.pop();

                if (stack.isEmpty()) break;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}));
    }
}
