import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        Set<Integer> deleteSet = new HashSet<>();
        for (int d : delete_list) {
            deleteSet.add(d);
        }

        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            if (!deleteSet.contains(x)) {
                list.add(x);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
