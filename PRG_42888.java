/*
오픈채팅방
- Map을 사용해서 [아이디, 닉네임] 형식으로 저장
- 명령어는 list로 저장

1. 파라미터 분리
2. Enter 명령어 일 경우
    - 사용자정보map에 아이디와 닉네임 저장
    - 아이디가 동일할 경우, 닉네임 변경
    - 명령어list에 명령어 입력 (아이디로 입력)
3. Leave 명령어 일 경우
    - 명령어list에 명령어 입력
4. Change 명령어 일 경우
    - 사용자정보map에 닉네임 변경
5. 명령어를 탐색하면서 아이디를 닉네임으로 치환
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PRG_42888 {
    static String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> info = new HashMap<>();
        List<String> command = new ArrayList<>();

        for (String r: record) {
            String[] str = r.split(" ");

            switch (str[0]) {
                case "Enter":
                    if (!info.containsKey(str[1])) {
                        info.put(str[1], str[2]);
                    } else {
                        info.replace(str[1], str[2]);
                    }
                    command.add(str[1] + "님이 들어왔습니다");
                    break;
                case "Leave":
                    command.add(str[1] + "님이 나갔습니다.");
                    break;
                case "Change":
                    info.replace(str[1], str[2]);
                    break;
            }
        }

        for (String list: command) {
            String id = list.split("님")[0];
            answer.add(info.get(id) + list.substring(id.length()));
        }

        return answer.toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] answer = solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        for(String str: answer) {
            System.out.println(str);
        }
    }
}
