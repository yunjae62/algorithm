import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K, answer;
    static int[][] rooms = new int[2][7];

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = stoi(st.nextToken());
            int Y = stoi(st.nextToken());
            rooms[S][Y]++;
        }

        for (int s = 0; s < 2; s++) {
            for (int y = 1; y < 7; y++) {
                answer += rooms[s][y] / K;

                if (rooms[s][y] % K != 0) {
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }
}
