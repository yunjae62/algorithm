import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int V, E, totalCost;
    static int[] parents;
    static Queue<Edge> q = new PriorityQueue<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = stoi(st.nextToken());
        E = stoi(st.nextToken());

        parents = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());
            int cost = stoi(st.nextToken());

            Edge edge = new Edge(u, v, cost);
            q.add(edge);
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
        if (parents[x] == x) {
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
