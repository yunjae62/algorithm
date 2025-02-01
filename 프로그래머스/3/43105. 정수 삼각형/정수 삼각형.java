import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];
            for (int j = 1; j < triangle[i].length - 1; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
            }
            triangle[i][i] += triangle[i - 1][i - 1];
        }
        
        return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
    }
}