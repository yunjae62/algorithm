import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parents;
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        parents = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int op = stoi(st.nextToken());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            int aRoot = find(a);
            int bRoot = find(b);

            if (op == 1) {
                sb.append(aRoot == bRoot ? "YES" : "NO").append("\n");
            } else {
                parents[Math.max(aRoot, bRoot)] = Math.min(aRoot, bRoot);
            }
        }

        System.out.println(sb);
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }
}
