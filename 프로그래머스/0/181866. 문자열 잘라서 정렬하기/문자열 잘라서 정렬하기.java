import java.util.*;

class Solution {
    public String[] solution(String myString) {
        return Arrays.stream(myString.split("x"))
            .filter(s -> !s.isEmpty())
            .sorted()
            .toArray(String[]::new);
    }
}