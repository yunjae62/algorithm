import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int max1 = numbers[0] * numbers[1];
        int max2 = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        return Math.max(max1, max2);
    }
}