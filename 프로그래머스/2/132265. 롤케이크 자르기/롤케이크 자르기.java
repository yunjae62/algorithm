import java.util.*;

class Solution {
    
    Map<Integer, Integer> left = new HashMap<>();
    Map<Integer, Integer> right = new HashMap<>();
    
    public int solution(int[] toppings) {
        int answer = 0;
        
        for (int topping : toppings) {
            right.put(topping, right.getOrDefault(topping, 0) + 1);
        }
        
        for (int topping : toppings) {
            left.put(topping, left.getOrDefault(topping, 0) + 1);
            right.put(topping, right.get(topping) - 1);
            
            if (right.get(topping) == 0) {
                
                right.remove(topping);
            }
            
            if (left.size() == right.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}

// Map<Integer, Integer> left, right 준비
// right에 전부 넣기 
// 각 for 문 돌면서 현재 요소를 left에 넣고, right에 넣는데 0개되면 삭제 
// left, right의 size가 같으면 answer++