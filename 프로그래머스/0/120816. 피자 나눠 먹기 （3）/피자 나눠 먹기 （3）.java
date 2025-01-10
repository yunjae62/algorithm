class Solution {
    public int solution(int slice, int n) {
        int answer = n / slice;
        if (n % slice != 0) {
            answer++;
        }
        return answer;
    }
}