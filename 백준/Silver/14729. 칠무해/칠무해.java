import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static double[] scores;
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        scores = new double[N];

        for (int i = 0; i < N; i++) {
            scores[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(scores);

        for (int i = 0; i < 7; i++) {
            sb.append(String.format("%.3f\n", scores[i]));
        }

        System.out.println(sb);
    }
}