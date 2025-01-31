class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int walletMax = Math.max(wallet[0], wallet[1]);
        int walletMin = Math.min(wallet[0], wallet[1]);
        
        int billMax = Math.max(bill[0], bill[1]);
        int billMin = Math.min(bill[0], bill[1]);
        
        while (billMin > walletMin || billMax > walletMax) {
            int temp = billMax /= 2;
            
            billMax = Math.max(temp, billMin);
            billMin = Math.min(temp, billMin);
            
            answer++;
        }
        
        return answer;
    }
}