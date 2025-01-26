import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0L;
        long left = 1;
        long right = Arrays.stream(times).max().getAsInt() * (long) n;

        while (left <= right) {
            long mid = (left + right) / 2;

            long total = 0;
            for (int time : times) {
                total += mid / time;
            }

            if (total >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}