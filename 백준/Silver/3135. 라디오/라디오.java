import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B, N;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = stoi(st.nextToken());
        B = stoi(st.nextToken());
        N = stoi(br.readLine());

        int min = Math.abs(A - B);

        for (int i = 0; i < N; i++) {
            int x = stoi(br.readLine());

            if (Math.abs(x - B) + 1 < min) {
                min = Math.abs(x - B) + 1;
            }
        }

        System.out.println(min);
    }
}