import java.util.ArrayList;
import java.util.List;

/*
1. dfs로 트리 타고타고 만들기..!
2. 입력값과 동일한 거 찾으면 리턴
 */
public class PRG_84512 {

    static char[] WORDS = {'A', 'E', 'I', 'O', 'U'};
    static int answer;
    static List<String> list;

    static int solution(String word) {
        list = new ArrayList<>();

        // dfs
        for (char cur: WORDS) { // 6번 dfs 타기
            dfs(String.valueOf(cur), word);
        }
        return answer;
//        return list.indexOf(word) + 1;
    }

    static void dfs(String cur, String word) {
        // dfs 탈출조건
        if(cur.length() > 5) return;

        // 정답일 경우
        if(word.equals(cur)) {
            answer = list.size() + 1;
            return;
        }

        // 정답을 못 찾았을 경우
        if (answer == 0) {
            // 사전에 안 넣은 단어는 사전에 넣기
            if(!list.contains(cur)) list.add(cur);

            // 다음 검색
            for (char c : WORDS) {
                dfs(cur + c, word);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
        System.out.println(solution("AAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));
    }
}
