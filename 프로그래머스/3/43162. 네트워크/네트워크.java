import java.util.*;

class Solution {
    
    boolean[] visited;
    int N;
    
    public int solution(int n, int[][] computers) {
        N = n;
        visited = new boolean[n];
        int networks = 0;
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                networks++;
            }
        }
        
        return networks;
    }
    
    void bfs(int start, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int i = 0; i < N; i++) {
                if (computers[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}