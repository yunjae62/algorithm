import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] peoples;
    static int[][] memo;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        peoples = new int[N + 1];
        memo = new int[N + 1][2];
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            peoples[i] = stoi(st.nextToken());
            Arrays.fill(memo[i], -1);
        }

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.println(Math.max(traversal(1, 0), traversal(1, 1) + peoples[1]));
    }

    static int traversal(int now, int flag) {
        if (graph.get(now).isEmpty()) {
            return 0;
        }

        if (memo[now][flag] != -1) {
            return memo[now][flag];
        }

        visited[now] = true;
        memo[now][flag] = 0;

        for (int next : graph.get(now)) {
            if (visited[next]) {
                continue;
            }

            if (flag == 1) {
                memo[now][flag] += traversal(next, 0);
            } else {
                memo[now][flag] += Math.max(traversal(next, 1) + peoples[next], traversal(next, 0));
            }
        }

        visited[now] = false;

        return memo[now][flag];
    }
}
