class Solution {
    public int solution(int n, String control) {
        for (char ch : control.toCharArray()) {
            if (ch == 'w') {
                n++;
            } else if (ch == 's') {
                n--;
            } else if (ch == 'd') {
                n += 10;
            } else {
                n -= 10;
            }
        }
        return n;
    }
}