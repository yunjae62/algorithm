import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer> sequences = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = stoi(st.nextToken());

            if (num == 0) {
                sequences.add(i + 1);
            } else {
                sequences.add(i - num, i + 1);
            }
        }

        for (int sequence : sequences) {
            sb.append(sequence).append(" ");
        }

        System.out.println(sb);
    }
}
