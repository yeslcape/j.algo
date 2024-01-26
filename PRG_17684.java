/*
1. 길이가 1인 모든 단어를 포함하도록 사전 초기화 : 'A' char 사용
2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w 찾기
    - 이중 반복문
        - 밖 : 앞 문자열 위치
        - 안 : 끝 문자열 위치
3. 사전에 없는 문자열은 list에 담기
 */

import java.util.ArrayList;
import java.util.Arrays;

public class PRG_17684 {
    static int[] solution(String msg) {
        // 단어 사전 초기화
        ArrayList<String> dic = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            dic.add(String.valueOf((char)('A' + i)));
        }

        // 답
        ArrayList<Integer> result = new ArrayList<>();

        // 문자열 구하기
        int idx = 0;
        while(idx < msg.length()) {
            String temp = "";
            int i = idx; // 앞 문자열은 바뀌면 안 됨
            for (int j = i; j < msg.length(); j++) {
                if (dic.contains(msg.substring(i, j + 1))) {
                    temp = msg.substring(i, j + 1); // 사전에 있는 문자열
                    idx++; // 다음에 검색할 문자열 시작점
                } else { // 동일한 문자열 없음
                    dic.add(msg.substring(i, j + 1)); // 사전에 넣기
                    break;
                }
            }
            result.add(dic.indexOf(temp) + 1); // 사전에 있는 가장 긴 문자열 위치
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    public static void main(String[] args) {
        int[] answer = solution("KAKAO");
        System.out.println(Arrays.toString(answer));

        answer = solution("TOBEORNOTTOBEORTOBEORNOT");
        System.out.println(Arrays.toString(answer));

        answer = solution("ABABABABABABABAB");
        System.out.println(Arrays.toString(answer));
    }
}
