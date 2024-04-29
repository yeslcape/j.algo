/*
쿼드압축 후 개수 세기
- 특정 영역 안 모든 수가 같은 값이면 하나로 압축
- 그렇지 않다면, 특정 영역을 4개의 정사각형 영역으로 쪼갠 뒤 압축 시도

재귀
- 모든 수 같은지 확인
- 안 같으면 4개로 쪼개서 재귀 태우기
- 같으면 true 리턴
 */

import java.util.Arrays;

public class PRG_68936 {
    static int[] answer;
    static int[] solution(int[][] arr) {
        answer = new int[] {0, 0}; // 0 개수, 1 개수
        quad(arr, 0, 0, arr.length);
        return answer;
    }

    // 쿼드 재귀
    static void quad(int[][] arr, int x, int y, int size) {
        if (isCompress(arr, x, y, size, arr[x][y])) { // 압축 가능하면
            if (arr[x][y] == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
        } else {
            quad(arr, x, y, size / 2);
            quad(arr, x + size / 2, y, size / 2);
            quad(arr, x + size / 2, y + size / 2, size / 2);
            quad(arr, x, y + size / 2, size / 2);
        }
    }

    // 압축 가능 여부 확인
    static boolean isCompress(int[][] arr, int x, int y, int size, int val) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != val) { // 같지 않으면
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}})));
        System.out.println(Arrays.toString(solution(new int[][]{{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}})));
    }
}
