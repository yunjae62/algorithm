import java.util.*;

class Solution {
    public boolean solution(String[] books) {
        Set<String> set = new HashSet<>();
        
        for (String book : books) {
            set.add(book);
        }
        
        for (String book : books) {
            for (int i = 1; i < book.length(); i++) {
                if (set.contains(book.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}