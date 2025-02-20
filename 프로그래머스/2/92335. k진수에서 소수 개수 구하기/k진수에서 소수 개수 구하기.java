import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        return (int) Arrays.stream(Integer.toString(n, k).split("0"))
                .filter(x -> !x.isEmpty())
                .mapToLong(Long::parseLong)
                .filter(this::isPrime)
                .count();
    }

    boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}