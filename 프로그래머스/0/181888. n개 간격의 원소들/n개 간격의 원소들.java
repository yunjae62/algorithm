class Solution {
    public int[] solution(int[] num_list, int n) {
        int m = (num_list.length - 1) / n + 1;
        int[] answer = new int[m];
        for (int i = 0; i < num_list.length; i += n) {
            answer[i / n] = num_list[i];
        }
        return answer;
    }
}