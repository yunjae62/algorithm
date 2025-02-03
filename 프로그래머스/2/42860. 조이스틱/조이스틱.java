class Solution {
    public int solution(String name) {
        char[] names = name.toCharArray();
        
        int vertical = 0;
        int horizontal = names.length - 1;
        
        for (int i = 0; i < names.length; i++) {
            vertical += Math.min(names[i] - 'A', 'Z' - names[i] + 1);
            
            if (i < names.length - 1 && names[i + 1] == 'A') {
                int lastIndexOfA = i + 1;
                
                while (lastIndexOfA < names.length && names[lastIndexOfA] == 'A') {
                    lastIndexOfA++;
                }
                
                horizontal = Math.min(horizontal, 2 * i + names.length - lastIndexOfA);
                horizontal = Math.min(horizontal, 2 * (names.length - lastIndexOfA) + i);
            }
        }
        
        return vertical + horizontal;
    }
}