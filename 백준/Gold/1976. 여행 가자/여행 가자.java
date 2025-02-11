import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parents;
    static int[][] graph;
    static Set<Integer> trees = new HashSet<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(br.readLine());

        parents = new int[N];
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = stoi(st.nextToken());

                if (graph[i][j] == 1) {
                    int aRoot = find(i);
                    int bRoot = find(j);

                    if (aRoot != bRoot) {
                        parents[Math.max(aRoot, bRoot)] = Math.min(aRoot, bRoot);
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            trees.add(parents[stoi(st.nextToken()) - 1]);

            if (trees.size() > 1) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }
}
