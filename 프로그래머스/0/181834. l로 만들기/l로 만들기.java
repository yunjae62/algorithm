class Solution {
    public String solution(String myString) {
        char[] chars = myString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 'l') {
                chars[i] = 'l';
            }
        }
        return String.valueOf(chars);
    }
}