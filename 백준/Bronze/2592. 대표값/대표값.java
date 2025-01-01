import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    static int avg, mode;
    static Map<Integer, Integer> map = new HashMap<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int num = stoi(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
            avg += num;
        }

        int[] modes = map.entrySet().stream().sorted(Comparator.comparingInt(Entry::getValue)).mapToInt(Entry::getKey).toArray();
        mode = modes[modes.length - 1];

        System.out.println(avg / 10);
        System.out.println(mode);
    }
}
