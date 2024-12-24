class Solution {
    public int solution(int n) {
        boolean[] composites = new boolean[Math.max(2, n) + 1];
        composites[0] = composites[1] = true;
        int answer = 0;
        
        for (int i = 2; i * i <= n; i++) {
            if (!composites[i]) {
                for (int j = i * i; j <= n; j += i) {
                    composites[j] = true;
                }
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (!composites[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}