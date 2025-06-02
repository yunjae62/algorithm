import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, d, count, place = 1;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        d = st.nextToken().charAt(0) - '0';

        while (place <= N) {
            int higher = N / (place * 10);
            int current = (N / place) % 10;
            int lower = N % place;

            if (d != 0) {
                if (current > d) {
                    count += (higher + 1) * place;
                } else if (current == d) {
                    count += higher * place + (lower + 1);
                } else {
                    count += higher * place;
                }
            } else {
                if (higher > 0) {
                    count += (higher - 1) * place + (current > 0 ? place : lower + 1);
                }
            }

            place *= 10;
        }

        System.out.println(count);
    }
}
