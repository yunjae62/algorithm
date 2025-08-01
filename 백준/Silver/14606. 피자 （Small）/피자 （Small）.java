import java.util.Scanner;

public class Main {

    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dfs(N);
        System.out.println(answer);
    }

    static void dfs(int n) {
        if (n == 1) {
            return;
        }

        int x = n / 2;
        int y = n - x;
        answer += x * y;

        dfs(x);
        dfs(y);
    }
}
