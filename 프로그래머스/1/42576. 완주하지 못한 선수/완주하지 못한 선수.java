import java.util.*;

class Solution {
    public String solution(String[] participants, String[] completion) {
        String answer = "";
        Map<String, Integer> names = new HashMap<>();
        
        for (String name : completion) {
            names.put(name, names.getOrDefault(name, 0) + 1);
        }
        
        for (String participant : participants) {
            if (!names.containsKey(participant)) {
                answer = participant;
                continue;
            }
            
            names.put(participant, names.get(participant) - 1);
            
            if (names.get(participant) == 0) {
                names.remove(participant);
            }
        }
        
        return answer;
    }
}