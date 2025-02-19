import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nicknames = new HashMap<>();
        Map<String, String> messages = Map.of(
                "Enter", "님이 들어왔습니다.",
                "Leave", "님이 나갔습니다."
        );

        for (String s : record) {
            String[] split = s.split(" ");

            if (split.length == 3) {
                nicknames.put(split[1], split[2]);
            }
        }

        List<String> answer = new ArrayList<>();

        for (String s : record) {
            String[] split = s.split(" ");
            
            if (messages.containsKey(split[0])) {
                answer.add(nicknames.get(split[1]) + messages.get(split[0]));
            }
        }

        return answer.toArray(String[]::new);
    }
}