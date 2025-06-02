import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, count;
    static char d;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        d = st.nextToken().charAt(0);

        for (int i = 1; i <= N; i++) {
            char[] arr = String.valueOf(i).toCharArray();
            for (char c : arr) {
                if (c == d) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}