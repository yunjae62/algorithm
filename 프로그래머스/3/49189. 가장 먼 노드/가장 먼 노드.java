import java.util.*;

class Solution {

    public int solution(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1); 
        distances[1] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                if (distances[next] == -1) {
                    distances[next] = distances[now] + 1;
                    q.add(next);
                }
            }
        }

        int max = Arrays.stream(distances).max().getAsInt();
        int count = 0;
        
        for (int distance : distances) {
            if (distance == max) {
                count++;
            }
        }

        return count;
    }
}
