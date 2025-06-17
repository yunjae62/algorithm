import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M, count;
    static Set<Integer> cd;
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = stoi(st.nextToken());
            M = stoi(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            cd = new HashSet<>();
            count = 0;

            for (int i = 0; i < N; i++) {
                cd.add(stoi(br.readLine()));
            }

            for (int i = 0; i < M; i++) {
                if (cd.contains(stoi(br.readLine()))) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}