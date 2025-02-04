import java.util.*;

class Solution {
    
    int N, K;
    int[] distances;
    boolean[] visited;
    List<List<Edge>> graph = new ArrayList<>();
    
    public int solution(int N, int[][] roads, int K) {
        int answer = 0;
        this.N = N;
        this.K = K;
        
        distances = new int[N + 1];
        Arrays.fill(distances, Integer.MAX_VALUE / 10);
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            graph.get(road[0]).add(new Edge(road[1], road[2]));
            graph.get(road[1]).add(new Edge(road[0], road[2]));
        }

        return dijkstra(1);
    }
    
    int dijkstra(int start) {
        Queue<Edge> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.add(new Edge(start, 0));
        distances[start] = 0;
        
        while (!q.isEmpty()) {
            Edge now = q.poll();
            
            if (visited[now.dest]) {
                continue;
            }
            
            visited[now.dest] = true;
            
            for (Edge next : graph.get(now.dest)) {
                int cost = distances[now.dest] + next.cost;
                if (distances[next.dest] > cost) {
                    distances[next.dest] = cost;
                    q.add(new Edge(next.dest, cost));
                }
            }
        }
        
        return (int) Arrays.stream(distances).filter(x -> x <= K).count();
    }
    
    class Edge {
        int dest, cost;
        
        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}