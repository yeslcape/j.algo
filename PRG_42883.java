/*
큰 수 만들기
- 어떤 숫자에서 K개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자
- 위치 바뀌면 안됨
 */

public class PRG_42883 {

    static String solution(String number, int k) {
        int len = number.length() - k - 1; // 답의 길이
        int idx = 0; // 자리

        StringBuilder sb = new StringBuilder();

        while(len >= 0){
            char max = '0';
            for(int i = idx; i < number.length() - len; i++){ // 숫자의 길이는 number.length() - k
                if(number.charAt(i) > max){
                    max = number.charAt(i);
                    idx = i + 1;
                    if(number.charAt(i) == '9'){ // 9일 경우 제거X
                        break;
                    }
                }
            }
            sb.append(max);
            len--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }
}
