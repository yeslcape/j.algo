/*
주차 요금 계산
- 주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 차량별로 주차 요금을 계산
- 00:00 ~ 23:59까지의 입출차 내역을 바탕으로 차량별 누적 주차 시간 계산
- 차량 번호가 작은 자동차부터 청구할 주차 요금을 return

1. 차번호+시간, 차번호+요금 해시맵 선언
2. 차량 기록 배열을 돌면서 차번호+시간 해시맵에 등록
    2-1. 입차시간 해시에 저장
    2-2. 출차하면 입차시간과 출차시간 계산하여, 요금 계산해서 차번호+요금 해시맵에 insert 또는 update / 차번호+시간 해시에서 삭제
    2-3. 아직 출차하지 않은 차는 23:59 - 입차 시간으로 해서 차번호+요금 해시맵에 등록
3. 차량 번호 작은 자동차부터 정렬

해시맵 + 정렬
 */

import java.util.*;

public class PRG_92341 {

    static int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        // 주차한 차들의 번호와 시간
        Map<String, String> parkingTime = new HashMap<>();
        // 차들의 번호와 누적된 요금 - 차번호로 정렬하기 위한 TreeMap 사용
        Map<String, Integer> parkingFees = new TreeMap<>();

        // 미리 세팅하는 이유 : map에서 있는지 없는지 체크보다 미리 넣어놓고 바꾸는 게 더 시간 빠르다고 생각했는데... HashMap 시간복잡도 계산해보기..!!!
        for (String record: records) {
            parkingFees.put(record.split(" ")[1], 0); // 차번호 + 요금 0원 미리 세팅
        }

        for (String record: records) {
            String[] carInfo = record.split(" ");

            if (parkingTime.containsKey(carInfo[1])) { // 출차
                String[] in = parkingTime.remove(carInfo[1]).split(":"); // 입차시간
                String[] out = carInfo[0].split(":"); // 출차시간

                int hour = Integer.parseInt(out[0]) - Integer.parseInt(in[0]);
                int minute = Integer.parseInt(out[1]) - Integer.parseInt(in[1]);

                parkingFees.replace(carInfo[1], parkingFees.get(carInfo[1]) + 60 * hour + minute);
            } else {
                parkingTime.put(carInfo[1], carInfo[0]);
            }
        }

        // 아직 출차하지 않은 차
        for (String key: parkingTime.keySet()) {
            String[] in = parkingTime.get(key).split(":");

            int hour = 23 - Integer.parseInt(in[0]);
            int minute = 59 - Integer.parseInt(in[1]);

            parkingFees.replace(key, parkingFees.get(key) + 60 * hour + minute);
        }

        // 찐 요금 계산
        // 요금 = 기본요금 + ((min-기본시간) / 단위시간) * 단위요금
        List<Integer> answerList = new ArrayList<>(parkingFees.size());
        for (Integer parkingFee: parkingFees.values()) {
            int basicTime = fees[0];
            int basicCharge = fees[1];
            int unitTime = fees[2];
            int unitCharge = fees[3];

            if (parkingFee <= basicTime) {
                answerList.add(basicCharge);
            } else {
                answerList.add((int)(basicCharge + Math.ceil((double) (parkingFee - basicTime) / unitTime) * unitCharge));
            }
        }

        // 배열로 변경 및 올림 작업
        answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        for (int a: arr1) {
            System.out.print(a + " ");
        }
        System.out.println();

        int[] arr2 = solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"});
        for (int a: arr2) {
            System.out.print(a + " ");
        }
        System.out.println();

        int[] arr3 = solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"});
        for (int a: arr3) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
