import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int start = 0;
        
        Arrays.sort(people);
        
        for (int end = people.length - 1; start <= end; end--) {
            if (people[start] + people[end] <= limit) {
                start++;
            }
            
            answer++;
        }
        
        return answer;
    }
}