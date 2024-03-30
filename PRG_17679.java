import java.util.ArrayList;
import java.util.List;

public class PRG_17679 {
    static char[][] blocks;

    static int solution(int m, int n, String[] board) {
        int answer = 0;

        blocks = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                blocks[i][j] = board[i].charAt(j);
            }
        }

        while(true) {
            // 2x2 블록 전부 지우고 확인 (블록이 지워졌는지)
            // 블록 지워진 게 없으면 false = 다 끝남
            int cnt = check();
            if (cnt > 0) {
                answer += cnt;
            } else {
                break;
            }
        }

        return answer;
    }

    // 2x2 블록 탐색
    static int check() {
        boolean[][] chkBlk = new boolean[blocks.length][blocks[0].length];

        // 2x2 블록 유무 탐색
        for (int i = 0; i < blocks.length - 1; i++) {
            for (int j = 0; j < blocks[0].length - 1; j++) {
                char c = blocks[i][j]; // 현재 블록

                // 블록이 없는 경우
                if (c == '0') continue;

                // 2x2 블록 같을 경우
                if (c == blocks[i + 1][j] && c == blocks[i][j + 1] && c == blocks[i + 1][j + 1]) {
                    chkBlk[i][j] = true;
                    chkBlk[i + 1][j] = true;
                    chkBlk[i][j + 1] = true;
                    chkBlk[i + 1][j + 1] = true;
                }
            }
        }

        // 블록 삭제
        return remove(chkBlk);
    }

    // 블록 삭제
    static int remove(boolean[][] rmBlk) {
        int cnt = 0; // 삭제될 블록 갯수

        for (int i = 0; i < rmBlk[0].length; i++) { // 열
            List<Character> tmp = new ArrayList<>(); // 새로 갱신될 열
            for (int j = rmBlk.length - 1; j >= 0; j--) { // 마지막 행부터
                if (rmBlk[j][i]) {
                    cnt++;
                    continue;
                }
                tmp.add(blocks[j][i]);
            }

            // cur : 현재의 행
            // 문자를 블록에 갱신
            for (int j = rmBlk.length - 1, cur = 0; j >= 0; j--, cur++) {
                if (cur < tmp.size()) {
                    blocks[j][i] = tmp.get(cur);
                } else {
                    blocks[j][i] = '0';
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMC", "TMMTTJ"}));
    }
}
