import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int OP = 1_000_000_009;
    static int[] dp = new int[1_000_001];
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 1_000_001; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= OP;
            dp[i] += dp[i - 3];
            dp[i] %= OP;
        }

        while (T-- > 0) {
            int n = stoi(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}