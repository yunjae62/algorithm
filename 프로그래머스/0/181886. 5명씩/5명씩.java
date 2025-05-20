class Solution {
    public String[] solution(String[] names) {
        int len = (names.length - 1) / 5 + 1;
        String[] answer = new String[len];
        for (int i = 0; i < len; i++) {
            answer[i] = names[5 * i];
        }
        return answer;
    }
}