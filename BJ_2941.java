/*
크로아티아 알파벳
- 문자열

1. 문자열 입력받기
2. 2개씩 읽으면서 croatia 문자 있는지 확인
    - 있으면 그 다음 문자 읽기
 */

import java.util.Scanner;

public class BJ_2941 {
    public static void main(String[] args) {
        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            String cur = String.valueOf(str.charAt(i));
            if (i != str.length() - 1) {
                cur += str.charAt(i + 1);
            }

            if ("dz".equals(cur)) {
                if (i + 2 < str.length() && str.charAt(i + 2) == '=') {
                    i += 2;
                    answer++;
                    continue;
                }
            }

            boolean chk = false;
            for (String c: croatia) {
                if (cur.equals(c)) {
                    i++;
                    chk = true;
                    answer++;
                    break;
                }
            }

            if (!chk) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
