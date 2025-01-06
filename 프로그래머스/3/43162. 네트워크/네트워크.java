import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                dfs(node, n, visited, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(int now, int n, boolean[] visited, int[][] computers) {
        for (int next = 0; next < n; next++) {
            if (computers[now][next] == 1 && !visited[next]) {
                visited[next] = true;
                dfs(next, n, visited, computers);
            }
        }
    }
}