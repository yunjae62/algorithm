class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder(index_list.length);
        for (int i : index_list) {
            sb.append(my_string.charAt(i));
        }
        return sb.toString();
    }
}