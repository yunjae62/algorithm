class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        
        for (int x : array) {
            if (x > height) {
                answer++;
            }
        }
        
        return answer;
    }
}