import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int work : works) {
            pq.add(work);
        }
        
        while (n > 0) {
            int work = pq.poll();
            
            if (work <= 0) {
                break;
            }
            
            pq.add(work - 1);
            n--;
        }
        
        while (!pq.isEmpty()) {
            long work = pq.poll();
            answer += work * work;
        }
        
        return answer;
    }
}