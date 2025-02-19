import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] towns;
    static int[][] memos;
    static List<List<Integer>> graph = new ArrayList<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        towns = new int[N + 1];
        memos = new int[N + 1][2];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            Arrays.fill(memos[i], -1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            towns[i] = stoi(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.println(Math.max(rec(1, -1, 0), rec(1, -1, 1) + towns[1]));
    }

    static int rec(int now, int prev, int flag) {
        if (memos[now][flag] != -1) {
            return memos[now][flag];
        }

        memos[now][flag] = 0;

        for (int next : graph.get(now)) {
            if (next == prev) {
                continue;
            }

            if (flag == 1) {
                memos[now][flag] += rec(next, now, 0);
            } else {
                memos[now][flag] += Math.max(rec(next, now, 0), rec(next, now, 1) + towns[next]);
            }
        }

        return memos[now][flag];
    }
}
