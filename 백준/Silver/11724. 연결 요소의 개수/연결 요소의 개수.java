import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parents;
    static Queue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.u));
    static Set<Integer> connectedComponents = new HashSet<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Edge now = new Edge(stoi(st.nextToken()), stoi(st.nextToken()));

            int aRoot = find(now.u);
            int bRoot = find(now.v);

            if (aRoot != bRoot) {
                parents[Math.max(aRoot, bRoot)] = Math.min(aRoot, bRoot);
            }
        }

        for (int i = 1; i <= N; i++) {
            connectedComponents.add(find(parents[i]));
        }

        System.out.println(connectedComponents.size());
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static class Edge {

        int u, v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}
