import java.util.HashSet;
import java.util.Set;

/*
방문 길이
- HashSet
- HashSet 사용 이유 : 중복 X

1. 현재 위치 + 다음 위치로 set에 저장
2. set에 없으면 새로운 경로이고, 있으면 기존 경로지만, set이어서 일단 그냥 저장
   - 0 0 0 1과 0 1 0 0은 같은 경로이기 때문에 정렬 필요
3. 답은 set size
 */
public class PRG_49994 {
    static int solution(String dirs) {
        int curX = 0;
        int curY = 0;

        Set<String> set = new HashSet<>();
        String road = "";

        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);

            // 다음 이동할 x, y
            int nextX = curX;
            int nextY = curY;

            switch (c) {
                case 'U': // U : 위쪽으로 한 칸 가기
                    nextY--;
                    // 현재 좌표 + 이동 후 좌표
                    road = curX + " " + curY + " " + nextX + " " + nextY;
                    break;
                case 'D': // D : 아래쪽으로 한 칸 가기
                    nextY++;
                    // 이동 후 좌표 + 현재 좌표
                    road = nextX + " " + nextY + " " + curX + " " + curY;
                    break;
                case 'R': // R : 오른쪽으로 한 칸 가기
                    nextX++;
                    // 현재 좌표 + 이동 후 좌표
                    road = curX + " " + curY + " " + nextX + " " + nextY;
                    break;
                case 'L': // L : 왼쪽으로 한 칸 가기
                    nextX--;
                    // 이동 후 좌표 + 현재 좌표
                    road = nextX + " " + nextY + " " + curX + " " + curY;
                    break;
            }

            //범위 벗어나면 무시
            if(nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5)
                continue;

            set.add(road);

            curX = nextX;
            curY = nextY;
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
        System.out.println(solution("UDU"));
    }
}
