import java.util.*;

class Solution {
    
    int[] distances;
    boolean[] visited;
    List<List<Edge>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] edges) {
        int answer = 0;
        
        distances = new int[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            graph.get(a).add(new Edge(b, 1));
            graph.get(b).add(new Edge(a, 1));
        }
        
        Arrays.fill(distances, Integer.MAX_VALUE);
        
        dijkstra();
        
        distances[0] = 0;
        int maxLen = Arrays.stream(distances).max().getAsInt();
        
        for (int distance : distances) {
            if (distance == maxLen) {
                answer++;
            }
        }
        
        return answer;
    }
    
    void dijkstra() {
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        distances[1] = 0;
        
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if (visited[now.dest]) {
                continue;
            }
            
            visited[now.dest] = true;
            
            for (Edge next : graph.get(now.dest)) {
                int nextCost = now.cost + next.cost;
                if (distances[next.dest] > nextCost) {
                    distances[next.dest] = nextCost;
                    pq.add(new Edge(next.dest, nextCost));
                }
            }
        }
    }
    
    class Edge implements Comparable<Edge> {
        
        int dest, cost;
        
        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
        
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}