import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];
        int INF = 1_000_000;
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        
        for (int[] result : results) {
            int win = result[0];
            int lose = result[1];
            graph[win][lose] = 1;
        }
        
        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    graph[start][end] = Math.min(graph[start][end], graph[start][mid] + graph[mid][end]);
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int result = 0;
            
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                
                if (graph[i][j] != INF || graph[j][i] != INF) {
                    result++;
                }
            }
            
            if (result == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}