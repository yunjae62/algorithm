import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        String first = sc.nextLine();
        String second = sc.nextLine();

        int[] firstCount = new int[26];
        int[] secondCount = new int[26];

        for (char ch : first.toCharArray()) {
            firstCount[ch - 'a']--;
        }

        for (char ch : second.toCharArray()) {
            secondCount[ch - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            int diff = Math.abs(firstCount[i] - secondCount[i]);

            if (diff != 0) {
                answer += diff;
            }
        }

        System.out.println(answer);
    }
}
