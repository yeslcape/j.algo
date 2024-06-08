/*
메뉴 리뉴얼
- 조합

모든 조합 만들기
- course 배열 내 조합 중 가장 많은 선택 받은 수가 max에 저장
 */

import java.util.*;

public class PRG_72411 {
    static String str;
    static HashMap<String, Integer> menu;
    static boolean[] isVisited;
    static int[] max;

    static String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        max = new int[course.length];
        menu = new HashMap<>();

        for (int i = 0; i < orders.length; i++) {
            char[] a = orders[i].toCharArray();
            Arrays.sort(a);
            str = String.copyValueOf(a);

            for (int j = 0; j < course.length; j++) {
                isVisited = new boolean[str.length()];
                comb(0, 0, "", j, course[j]);
            }
        }

        for (String s : menu.keySet())
            for (int i = 0; i < course.length; i++)
                if (course[i] == s.length() && max[i] != 1 && menu.get(s) == max[i])
                    answer.add(s);


        answer.sort(Comparator.naturalOrder());
        return answer.toArray(String[]::new);
    }

    // 조합
    static void comb(int cur, int cnt, String result, int j, int N) { // 선택할 문자 위치, 선택된 메뉴 개수, 선택된 메뉴 조합
        if (cnt == N) {
            menu.put(result, menu.containsKey(result) ? menu.get(result) + 1 : 1);
            max[j] = Math.max(max[j], menu.get(result));
            return;
        }

        for (int i = cur; i < str.length(); i++) {
            isVisited[i] = true;
            comb(i + 1, cnt + 1, result + str.charAt(i), j, N);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
        System.out.println(Arrays.toString(solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }
}
