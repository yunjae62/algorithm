class Solution {
    public int solution(int price) {
        int answer = 0;
        if (price >= 500_000) {
            answer = price * 8 / 10;
        } else if (price >= 300_000) {
            answer = price * 9 / 10;
        } else if (price >= 100_000) {
            answer = price * 95 / 100;
        } else {
            answer = price;
        }
        return answer;
    }
}