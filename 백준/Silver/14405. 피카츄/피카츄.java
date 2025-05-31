import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = {"pi", "ka", "chu"};

        String word = sc.nextLine();

        for (int i = 0; i < word.length(); i++) {
            boolean speak = false;
            for (String s : arr) {
                boolean startsWith = word.startsWith(s, i);
                if (startsWith) {
                    i += s.length() - 1;
                    speak = true;
                    break;
                }
            }
            if (speak) {
                continue;
            }

            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }
}
