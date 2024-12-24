class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int p = 0;
        int y = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == 'p') p++;
            if (ch == 'y') y++;
        }

        return p == y;
    }
}