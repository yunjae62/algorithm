import java.util.*;

class Solution {
    
    int N;
    boolean[] visited;
    Set<Integer> set = new HashSet<>();
    boolean[] composites;
    
    public int solution(String numbers) {
        int answer = 0;
        N = numbers.length();
        visited = new boolean[N];
        
        for (int i = 1; i <= N; i++) {
            dfs(0, 0, "", numbers, i);
        }
        
        System.out.println(set);
        int[] nums = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        
        int max = Math.max(2, nums[nums.length - 1]);
        composites = new boolean[max + 1];
        
        composites[0] = composites[1] = true;
        
        for (int i = 2; i * i <= max; i++) {
            if (!composites[i]) {
                for (int j = i * i; j <= max; j += i) {
                    composites[j] = true;
                }
            }
        }
        
        for (int num : nums) {
            if (!composites[num]) {
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(int depth, int now, String str, String numbers, int max) {
        if (depth == max) {
            set.add(Integer.valueOf(str));
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i, str + numbers.substring(i, i + 1), numbers, max);
                visited[i] = false;
            }
        }
    }
}