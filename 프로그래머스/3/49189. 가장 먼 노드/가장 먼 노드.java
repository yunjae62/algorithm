import java.util.*;

class Solution {

    int[] distances;
    List<List<Edge>> graph = new ArrayList<>();

    public int solution(int n, int[][] edges) {
        distances = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.get(a).add(new Edge(b, 1));
            graph.get(b).add(new Edge(a, 1));
        }

        Arrays.fill(distances, Integer.MAX_VALUE);
        dijkstra(1);

        int maxLen = Arrays.stream(distances, 1, distances.length).max().getAsInt();

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == maxLen) count++;
        }

        return count;
    }

    void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        distances[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (curr.cost > distances[curr.dest]) continue;

            for (Edge next : graph.get(curr.dest)) {
                int nextCost = curr.cost + next.cost;
                if (nextCost < distances[next.dest]) {
                    distances[next.dest] = nextCost;
                    pq.add(new Edge(next.dest, nextCost));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int dest, cost;
        Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
