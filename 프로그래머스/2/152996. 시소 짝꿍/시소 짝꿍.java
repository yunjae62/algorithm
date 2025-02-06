import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        
        Arrays.sort(weights);
        
        for (int intWeight : weights) {
            double weight = Double.valueOf(intWeight);
            
            if (map.containsKey(weight)) {
                answer += map.get(weight);
            }
            
            if (map.containsKey(weight / 2)) {
                answer += map.get(weight / 2);
            }
            
            if (map.containsKey(2 * weight / 3)) {
                answer += map.get(2 * weight / 3);
            }
            
            if (map.containsKey(3 * weight / 4)) {
                answer += map.get(3 * weight / 4);
            }
            
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }
        
        return answer;
    }
}