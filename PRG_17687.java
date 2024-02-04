/*
[3차] n진수 게임
1. 반복문 : 구할 숫자
2. 반복문 내부 : 변환
3. 튜브 순서에 맞게 글자들 추출
TIP : Integer.toString(숫자, n) : 숫자를 n진수로 변환
 */
public class PRG_17687 {

    public static String solution(int n, int t, int m, int p) {
        StringBuilder convert = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        // 반복문 : 구할 숫자 * 게임 참가 인원수만큼 돌리기
        int i = 0;
        while (convert.length() <= t * m) {
            convert.append(Integer.toString(i, n));
            i++;
        }

        // 글자들 추출
        i = p - 1;
        while (answer.length() < t) {
            answer.append(convert.charAt(i));
            i += m;
        }

        return answer.toString().toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
    }
}
