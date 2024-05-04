import java.util.HashMap;
import java.util.Map;

/*
[PCCP 기출문제] 1번 / 붕대 감기
- 붕대 감기는 t초 동안 붕대를 감으면서 1초마다 x만큼의 체력 회복
- t초 연속으로 붕대를 감는 데 성공한다면 y만큼의 체력 추가 회복
- 게임 캐릭터에는 최대 체력이 존재해 현재 체력이 최대 체력보다 커지는 것 X
- 기술을 쓰는 도중 몬스터에게 공격을 당하면 기술 취소
    - 공격을 당하는 순간에는 체력 회복 X
    - 몬스터에게 공격당해 기술이 취소당하거나 기술이 끝나면 그 즉시 붕대 감기를 다시 사용
    - 연속 성공 시간이 0으로 초기화
- 현재 체력이 0 이하가 되면 캐릭터가 죽으며 더 이상 체력 회복 X

bandage : 붕대 감기 기술 시전 시간 / 1초당 회복량 / 추가 회복량
health : 최대 체력
attacks : 몬스터 공격 시간 / 피해량
 */
public class PRG_250137 {
    static int solution(int[] bandage, int health, int[][] attacks) {
        Map<Integer, Integer> attackInfo = new HashMap<>();
        int h = health; // 체력
        int cBandage = 0; // 회복 횟수
        int endTime = 0;

        for (int[] attack: attacks) {
            attackInfo.put(attack[0], attack[1]);
            endTime = attack[0];
        }
        for (int time = 1; time <= endTime; time++) {
            if (attackInfo.containsKey(time)) { // 공격 시간
                h -= attackInfo.get(time);
                cBandage = 0;
            } else { // 회복 가능
                cBandage++;
                h += bandage[1];

                if (cBandage == bandage[0]) {
                    h += bandage[2];
                    cBandage = 0;
                }

                if (h > health) {
                    h = health;
                }
            }

            if (h <= 0) return -1;
        }

        return h;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
        System.out.println(solution(new int[]{3, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[]{4, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {3, 2}}));
    }
}
