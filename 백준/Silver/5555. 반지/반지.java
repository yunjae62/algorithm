import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, answer;
    static String word;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word = br.readLine();
        N = stoi(br.readLine());

        for (int i = 0; i < N; i++) {
            String ring = br.readLine();
            ring = ring + ring.substring(0, ring.length() - 1);

            if (ring.contains(word)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}