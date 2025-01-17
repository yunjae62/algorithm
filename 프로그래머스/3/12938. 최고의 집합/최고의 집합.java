class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] += s / n;
        }
        for (int i = n - 1; i >= n - s % n; i--) {
            answer[i]++;
        }
        
        return answer;
    }
}