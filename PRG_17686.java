/*
[3차] 파일명 정렬
- 문자열 & 정렬
- 파라미터로 들어온 리스트 정렬
- 숫자 이전 내용(head)로 먼저 정렬
- 문자로 된 숫자를 숫자로 변경하여 정렬
- tail로 정렬
 */

import java.util.Arrays;

public class PRG_17686 {
    static String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String head1 = o1.split("[0-9]")[0].toLowerCase();
            String head2 = o2.split("[0-9]")[0].toLowerCase();
            if (head1.compareTo(head2) == 0) { // 앞 영어가 같을 경우
                int number1 = getNumber(o1.substring(head1.length()));
                int number2 = getNumber(o2.substring(head2.length()));
                return number1 - number2;
            } else { // 영어로 먼저 정렬
                return head1.compareTo(head2);
            }
        });

        return files;
    }

    static int getNumber(String s) {
        StringBuilder number = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                return Integer.parseInt(number.toString());
            }
        }
        return Integer.parseInt(number.toString());
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println(Arrays.toString(solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }
}
