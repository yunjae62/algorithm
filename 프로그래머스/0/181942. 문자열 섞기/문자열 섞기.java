class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        int a = 0;
        int b = 0;
        
        while (a + b < str1.length() + str2.length()) {
            if (a < str1.length()) {
                answer += str1.substring(a, a + 1);
                a++;
            }
            
            if (b < str2.length()) {
                answer += str2.substring(b, b + 1);
                b++;
            }
        }
        
        return answer;
    }
}