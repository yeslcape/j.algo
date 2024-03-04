/*
땅따먹기
- DP
1. 다음행에 도착했을 때
- 같은 열은 밟을 수 없음
- 최고점을 만들어야 함
2. 마지막 행에 도착했을 때
- 가장 최고점이 답
 */
public class PRG_12913 {

    static int solution(int[][] land) {
        for (int row = 0; row < land.length - 1; row++) {
            // 열은 4개
            land[row + 1][0] += Math.max(Math.max(land[row][1], land[row][2]), land[row][3]);
            land[row + 1][1] += Math.max(Math.max(land[row][0], land[row][2]), land[row][3]);
            land[row + 1][2] += Math.max(Math.max(land[row][0], land[row][1]), land[row][3]);
            land[row + 1][3] += Math.max(Math.max(land[row][0], land[row][1]), land[row][2]);
        }
        return Math.max(land[land.length - 1][0], Math.max(land[land.length - 1][1], Math.max(land[land.length - 1][2], land[land.length - 1][3])));
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
    }
}
