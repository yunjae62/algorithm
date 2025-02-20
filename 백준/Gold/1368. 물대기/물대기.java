import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, totalCost;
    static int[] wells;
    static int[] parents;
    static Queue<Edge> q = new PriorityQueue<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        wells = new int[N];
        parents = new int[N + 1];

        for (int i = 0; i < N; i++) {
            wells[i] = stoi(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    st.nextToken();
                    q.add(new Edge(N, i, wells[i]));
                    continue;
                }

                q.add(new Edge(i, j, stoi(st.nextToken())));
            }
        }

        while (!q.isEmpty()) {
            Edge now = q.poll();

            int uRoot = find(now.u);
            int vRoot = find(now.v);

            if (uRoot != vRoot) {
                parents[Math.max(uRoot, vRoot)] = Math.min(uRoot, vRoot);
                totalCost += now.cost;
            }
        }

        System.out.println(totalCost);
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static class Edge implements Comparable<Edge> {

        int u, v, cost;

        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
