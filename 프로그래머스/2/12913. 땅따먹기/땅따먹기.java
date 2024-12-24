class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int N = land.length;
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                int now = land[i][j];
                
                for (int k = 0; k < 4; k++) {
                    if (j == k) {
                        continue;
                    }
                    
                    land[i][j] = Math.max(land[i][j], land[i - 1][k] + now);
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[N-1][i]);
        }

        return answer;
    }
}

// dp
// 현재 행/열에서 윗 행의 본인 열빼고 각각 더해보고 가장 큰 값으로 저장 