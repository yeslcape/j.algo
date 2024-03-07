import java.util.ArrayDeque;
import java.util.Queue;

/*
스킬트리
- skill : 배워야하는 스킬 순서
- skill_trees : 스킬 트리
- return : 정상적인(?) 스킬의 갯수
- 큐 사용한 완전탐색
 */
public class PRG_49993 {
    static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree: skill_trees) {
            Queue<Character> skill_queue = new ArrayDeque<>(); // 스킬 순서 넣기
            boolean finished = true;

            for (int i = 0; i < skill.length(); i++) {
                skill_queue.add(skill.charAt(i));
            }

            for (int i = 0; i < skill_tree.length(); i++) { // skill_tree 비교
                char cur = skill_tree.charAt(i);
                if (skill_queue.contains(cur)) { // skill_tree 문자가 skill에 있다면
                    if (cur != skill_queue.poll()) { // 하나 제거
                        finished = false;
                        break;
                    }
                }
            }

            if (finished) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
