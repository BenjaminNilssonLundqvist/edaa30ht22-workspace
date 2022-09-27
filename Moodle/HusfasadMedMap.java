import java.util.Map;
import java.util.TreeMap;

public class HusfasadMedMap {
    public static Map<Integer, Integer> digitMap(int start, int stop, int interval) {
        Map<Integer, Integer> tal = new TreeMap<Integer,Integer>();
        for (int i = 0; i < 10; i++) {
            tal.put(i, 0);
        }
        for (int i = start; i <= stop; i += interval) {
            int c = i % 10;
            tal.put(c, tal.get(c) + 1);

            if (i > 9) {
                int b = (i % 100) / 10;
                tal.put(b, tal.get(b) + 1);
            }
            if (i > 99) {
                int a = (i % 1000) / 100;
                tal.put(a, tal.get(a) + 1);
            }
        }
        return tal;

    }

    public static void main(String[] args) {
        System.out.println(digitMap(101, 125, 2));
    }

}
