class Solution {
    public int solution(String number) {
        int answer = 0;
        for (char ch : number.toCharArray()) {
            answer += ch - '0';
        }
        return answer % 9;
    }
}