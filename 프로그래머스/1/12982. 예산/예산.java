import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int totalCost = 0;
        Queue<Integer> q = new PriorityQueue<>();
        
        for (int num : d) {
            q.add(num);
        }
        
        while (!q.isEmpty() && totalCost + q.peek() <= budget) {
            int cost = q.poll();
            totalCost += cost;
            answer++;
        }
        
        return answer;
    }
}