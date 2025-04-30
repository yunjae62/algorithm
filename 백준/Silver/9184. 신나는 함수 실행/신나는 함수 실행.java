import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<String, Integer> dp = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int ans = w(a, b, c);

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(ans).append("\n");
        }

        System.out.println(sb);
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            String key = makeKey(20, 20, 20);
            if (dp.containsKey(key)) {
                return dp.get(key);
            }
            dp.put(key, w(20, 20, 20));
            return dp.get(key);
        }

        if (a < b && b < c) {
            String key = makeKey(a, b, c);
            if (dp.containsKey(key)) {
                return dp.get(key);
            }
            int value = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            dp.put(key, value);
            return dp.get(key);
        }

        String key = makeKey(a, b, c);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int value = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        dp.put(key, value);
        return dp.get(key);
    }

    static String makeKey(int a, int b, int c) {
        return String.format("%02d%02d%02d", a, b, c);
    }
}