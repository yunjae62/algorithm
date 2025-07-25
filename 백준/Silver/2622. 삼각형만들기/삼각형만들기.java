import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int answer = 0;

        for (int a = 1; a <= N / 3; a++) {
            for (int b = a; b <= (N - a) / 2; b++) {
                int c = N - a - b;
                if (b > c) {
                    break;
                }

                if (a + b > c) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
