import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PRG_152996 {

    static long solution(int[] weights) {
        long result = 0;

        Arrays.sort(weights);

        Map<Double, Integer> map = new HashMap<>();

        for (int w: weights) {
            double a = w * 1.0;// 같을 때
            double b = (w * 2.0) / 3.0; // 2/3
            double c = (w * 1.0) / 2.0; // 2/4
            double d = (w * 3.0) / 4.0; // 3/4

            if (map.containsKey(a)) result += map.get(a);
            if (map.containsKey(b)) result += map.get(b);
            if (map.containsKey(c)) result += map.get(c);
            if (map.containsKey(d)) result += map.get(d);

            map.put((w * 1.0), map.getOrDefault((w * 1.0), 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{100, 180, 360, 100, 270}));
    }
}
