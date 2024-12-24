import java.util.*;

class Solution {
    public int solution(int[] scovilles, int K) {
        int answer = 0;
        Queue<Integer> q = new PriorityQueue<>();
        
        for (int scoville : scovilles) {
            q.add(scoville);
        }
        
        while (q.peek() < K) {
            if (q.size() <= 1) {
                return -1;
            }
            
            answer++;
            
            int first = q.poll();
            int second = q.poll();
            int mix = first + 2 * second;
            
            q.add(mix);
        }
        
        return answer;
    }
}