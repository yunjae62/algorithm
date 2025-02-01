import java.util.*;

class Solution {
    
    static final int[] dx = {1, 0, -1};
    static final int[] dy = {0, 1, -1};
    
    public int[] solution(int n) {
        int x = 0;
        int y = 0;
        int d = 0;
        int count = 1;
        int[][] arr = new int[n][n];
        
        while (true) {
            arr[x][y] = count++;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if ((0 <= nx && nx < n) && (0 <= ny && ny < n) && (arr[nx][ny] == 0)) {
                x = nx;
                y = ny;
                continue;
            }
            
            d = (d + 1) % 3;
            nx = x + dx[d];
            ny = y + dy[d];
            
            if (!((0 <= nx && nx < n) && (0 <= ny && ny < n) && (arr[nx][ny] == 0))) {
                break;
            }
            
            x = nx;
            y = ny;
        }
        
        int idx = 0;
        int[] answer = new int[count - 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}