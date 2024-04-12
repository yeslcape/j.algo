/*
다리를 지나는 트럭
- 큐 선입선출
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class PRG_42583 {

    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> q = new ArrayDeque<>();

        int truck = 0;

        // 다리 길이가 1이면 트럭 하나씩 1초에 한 번씩 올라감
        if (bridge_length == 1) return truck_weights.length + 1;
        // 트럭이 한 개면, 다리 다 건너면 끝
        if (truck_weights.length == 1) return bridge_length + 1;

        // bridge 만큼 0 채우기
        for (int i = 0; i < bridge_length; i++) {
            q.add(0);
        }

        int total_truck_weights = 0; // 다리 위 전체 트럭 무게
        while(truck <= truck_weights.length - 1) {
            // 하나 빼기
            total_truck_weights -= q.poll();
            if (weight >= total_truck_weights + truck_weights[truck]) {
                q.add(truck_weights[truck]);
                total_truck_weights += truck_weights[truck++];
            } else {
                q.add(0);
            }
            time++;
        }

        // 시간 + 마지막 트럭이 지나가야하는 길이
        return time + bridge_length;
    }
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7,4,5,6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
}
