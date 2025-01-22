import java.util.*;

class Solution {
    public String solution(String numbers, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        for (int i = 0; i < numbers.length() - k; i++) {
            char max = '0';
            
            for (int j = idx; j <= i + k; j++) {
                if (numbers.charAt(j) > max) {
                    max = numbers.charAt(j);
                    idx = j + 1;
                }
            }
            
            sb.append(max);
        }
        
        return sb.toString(); 
    }
}

// 다음 문자가 더 크면 패스, 아니면 sb 넣음. 
// sb 사이즈 + 남은 문자열 길이가 N - k면 break ... 하면 안됨!

// 현재 문자가 다음 문자보다 낮으면 스택에 넣기. 
// 스택 피크가 다음 문자보다 크거나 같으면 계속 팝해서 sb에 넣기... 하면 안됨!
// sb 개수 + 남은 문자수가 N - k면 나머지 다 넣기 


// 그냥 무식하게 0부터 N - 1 - k까지 서브스트링 한 걸 리스트에 넣어서 정렬 후 가장 큰 거 넣기
// 이때 비교식은 (o2 + o1).compare(o1 + o1)
// 하면 틀림! 

// 각 수를 분리해서 힙에 넣기 - NlogN (= 2천만)
// k개 만큼 빼서 Map에 넣기 - N
// 수를 돌아가면서 각 수가 맵에 있으면 맵의 값을 하나 줄이고 넘어가고, 아니면 SB에 넣기 - N
// 를 하면 틀림! 