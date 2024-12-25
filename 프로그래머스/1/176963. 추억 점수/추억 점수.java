import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int N = photo.length;
        int[] answer = new int[N];
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < N; i++) {
            int total = 0;
            for (String target : photo[i]) {
                total += map.getOrDefault(target, 0);
            }
            answer[i] = total;
        }
        
        return answer;
    }
}