class Solution {
    public int solution(int a, int b) {
        boolean aOdd = a % 2 == 1;
        boolean bOdd = b % 2 == 1;
        
        if (aOdd && bOdd) {
            return a * a + b * b;
        } else if (aOdd || bOdd) {
            return 2 * (a + b);
        }
        return Math.abs(a - b);
    }
}