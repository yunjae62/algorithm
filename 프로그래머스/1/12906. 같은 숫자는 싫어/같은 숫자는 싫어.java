import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() == arr[i]) {
                continue;
            }
            
            stack.add(arr[i]);
        }
        
        int[] answer = new int[stack.size()];
        
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}