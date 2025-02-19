import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static Item[] items;
    static Integer[][] dp;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        dp = new Integer[N][K + 1];
        items = new Item[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(stoi(st.nextToken()), stoi(st.nextToken()));
        }

        System.out.println(rec(N - 1, K));
    }

    static int rec(int idx, int maxWeight) {
        if (idx < 0 || maxWeight < 0) {
            return 0;
        }

        if (dp[idx][maxWeight] != null) {
            return dp[idx][maxWeight];
        }

        Item item = items[idx];

        if (item.weight > maxWeight) {
            return dp[idx][maxWeight] = rec(idx - 1, maxWeight);
        }

        return dp[idx][maxWeight] = Math.max(rec(idx - 1, maxWeight), rec(idx - 1, maxWeight - item.weight) + item.value);
    }

    static class Item {

        int weight, value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
