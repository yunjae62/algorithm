import java.util.*;

class Solution {
    public int solution(int a, int b, int c) {
        Set<Integer> set = new HashSet<>();
        
        set.add(a);
        set.add(b);
        set.add(c);
        
        if (set.size() == 3) {
            return a + b + c;
        }
        
        if (set.size() == 1) {
            return (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
        }
        
        return (a + b + c) * (a * a + b * b + c * c);
    }
}