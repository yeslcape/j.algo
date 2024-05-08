/*
삼각 달팽이

1. 배열 크기를 정하기
    - 1
    - 1 + 2
    - 1 + 2 + 3 = n(n+1)/2
2. for문 돌면서 배열에 값 넣기
    - 달팽이 모양대로 값 넣기
3. 1차원 배열로 만들기
 */

import java.util.Arrays;

public class PRG_68645 {
    static int[] solution(int n) {
        // 배열 크기 정하기
        int[] result = new int[(n * (n + 1)) / 2];
        int[][] matrix = new int[n][n];

        int x = -1;
        int y = 0;
        int num = 1; // 1부터 시작

        // 달팽이 모양으로 값 넣기
        for (int i = 0; i < n; i++) { // 행
            for (int j = i; j < n; j++) { // 열
                if (i % 3 == 0) { // 아래
                    x++;
                } else if (i % 3 == 1) { // 오른쪽
                    y++;
                } else { // 대각선
                    x--;
                    y--;
                }

                matrix[x][y] = num++;
            }
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    break;
                result[k++] = matrix[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(5)));
        System.out.println(Arrays.toString(solution(6)));
    }
}
