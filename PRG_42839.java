import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/*
소수 찾기
- 완전 탐색

1. 순열로 만들 수 있는 숫자 만들기
    - 순열 사용 이유 : 17과 71은 다른 숫자이기 때문
2. 만든 숫자가 소수인지 확인
 */
public class PRG_42839 {

    static String[] numberList, permList;
    static boolean[] isSelected;
    static Set<Integer> set;

    static boolean isPrime(int number) {
        if (number <= 1) return false;
        else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) return false;
            }
        }
        return true;
    }

    static void permutation(int cnt, int r) {
        if (cnt == r) {
            int number = Integer.parseInt(String.join("", permList));
            // 소수인지
            if(isPrime(number)) {
                set.add(number);
            }
            return;
        }

        for (int i = 0; i < numberList.length; i++) {
            if (isSelected[i]) continue;
            permList[cnt] = numberList[i];
            isSelected[i] = true;
            permutation(cnt + 1, r);
            isSelected[i] = false;
        }
    }

    static int solution(String numbers) {
        set = new HashSet<>();

        for (int i = 1; i <= numbers.length(); i++) {
            numberList = numbers.split("");
            permList = new String[i];
            isSelected = new boolean[numbers.length()];

            permutation(0, i);
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }
}
