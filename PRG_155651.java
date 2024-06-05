/*
호텔 대실
- 우선순위 큐
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PRG_155651 {
    static class Room {
        int startMinute;
        int endMinute;

        public Room(String start, String end) {
            int clean = 10;

            this.startMinute = getMinutes(start);
            this.endMinute = getMinutes(end) + clean;
        }

        private int getMinutes(String time) {
            String[] timeArray = time.split(":");
            int hour = Integer.parseInt(timeArray[0]);
            int minute = Integer.parseInt(timeArray[1]);

            return hour * 60 + minute;
        }
    }

    static int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<Room> useRooms = new PriorityQueue<>(Comparator.comparingInt(o -> o.endMinute));

        Room[] rooms = new Room[book_time.length];
        for (int i = 0; i < book_time.length; i++) {
            rooms[i] = new Room(book_time[i][0], book_time[i][1]);
        }

        Arrays.sort(rooms, Comparator.comparingInt(o -> o.startMinute));

        for (Room room : rooms) {
            if (!useRooms.isEmpty() && room.startMinute >= useRooms.peek().endMinute) {
                useRooms.poll();
            } else {
                answer++;
            }

            useRooms.offer(room);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
        System.out.println(solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));
        System.out.println(solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}}));
    }
}
