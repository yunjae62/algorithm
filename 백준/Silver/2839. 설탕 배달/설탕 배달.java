import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] dp;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        dp = new int[Math.max(N, 5) + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[3] = dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            if (dp[i - 3] == Integer.MAX_VALUE && dp[i - 5] == Integer.MAX_VALUE) {
                continue;
            }

            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }

        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
    }
}
