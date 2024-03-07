import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
롤케이크 자르기
- HashMap 사용 이유 : 숫자 별로 몇 개씩인지 확인하기 위함
1. 형의 HashSet과 동생의 HashMap 선언
- 형 HashSet 이유 : 기준점으로 삼기. 값 별 몇 개인지는 상관 없음
- 동생 HashMap 이유 : 값 별 몇 개인지 알 필요 있음. 형이 더 가지수가 적으면 동생꺼에서 하나 제외해서 넘김

tip : hashMap.getOrDefault(key, default value)
- key 값을 가져오고, 없으면 default value를 return
 */
public class PRG_132265 {
    static int solution(int[] topping) {
        int answer = 0;

        Set<Integer> older = new HashSet<>();
        Map<Integer, Integer> younger = new HashMap<>();

        for (int t : topping) { // 동생에게 토핑 전부 넣어두기
            younger.put(t, younger.getOrDefault(t, 0) + 1); // 이미 저장한 토핑 있으면 개수 증가, 없으면 개수 1
        }

        for (int t : topping) {
            // 형에게 토핑 개수 하나 넘기기
            older.add(t);
            younger.put(t, younger.getOrDefault(t, 0) - 1);

            if (younger.get(t) == 0) younger.remove(t); // 이제 더 이상 동생에게 없는 토핑이면 동생 map에서 아예 제외

            if (older.size() == younger.size()) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
        System.out.println(solution(new int[]{1, 2, 3, 1, 4}));
    }
}
