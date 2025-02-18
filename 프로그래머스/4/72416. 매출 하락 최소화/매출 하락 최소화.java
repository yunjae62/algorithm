import java.util.*;
class Solution {
    public int[] sales;
    public int[][] dp;
    public Map<Integer, List<Integer>> teams = new HashMap<>();
    
    public int solution(int[] sales, int[][] links) {
        this.sales = sales;
        dp = new int[sales.length + 1][2];
        
        for (int i = 0; i < sales.length + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);   
        }
        
        for (int[] link : links) {
            if (!teams.containsKey(link[0])) {
                teams.put(link[0], new ArrayList<>());
            } 
            
            teams.get(link[0]).add(link[1]);
        }

        return Math.min(dfs(1, 0), dfs(1, 1));
    }

    public int dfs(int now, int isContain) {
        // 이미 계산한 값 재사용 
        if (dp[now][isContain] != Integer.MAX_VALUE) {
            return dp[now][isContain];
        }
        
        int totalSales = isContain == 0 ? 0 : sales[now - 1];
        
        // 리프 노드(팀장이 아닌 팀원)이면 해당 값 바로 리턴 
        if (!teams.containsKey(now)) {
            return totalSales;
        }

        int minContainDiff = Integer.MAX_VALUE;
        boolean containExist = false;
        
        for (int child : teams.get(now)) {
            int notContain = dfs(child, 0); // 팀원의 매출액 미포함
            int contain = dfs(child, 1); // 팀원의 매출액 포함 
            
            minContainDiff = Math.min(minContainDiff, contain - notContain);
            
            if (notContain < contain) {
                totalSales += notContain;
            } else {
                totalSales += contain;
                containExist = true;
            }
        }
        
        // 팀에서 아무도 참석 안 해서, 가장 낮은 매출액 가산
        // 미포함 값은 이미 totalSales에 포함되어 있어서 포함과의 차이만큼만 가산 
        if (isContain == 0 && !containExist) {
            totalSales += minContainDiff;   
        }

        return dp[now][isContain] = totalSales;
    }
}