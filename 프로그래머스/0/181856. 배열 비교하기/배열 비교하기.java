class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return arr1.length > arr2.length ? 1 : -1;
        }
        
        int sum1 = 0;
        for (int x : arr1) {
            sum1 += x;
        }
        
        int sum2 = 0;
        for (int x : arr2) {
            sum2 += x;
        }
        
        if (sum1 > sum2) {
            return 1;
        } else if (sum1 < sum2) {
            return -1;
        }
        
        return 0;
    }
}