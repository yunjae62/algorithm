import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int[] answer;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        arr = new int[N][5];
        answer = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = stoi(st.nextToken());
            }
        }

        for (int me = 0; me < N; me++) {
            int friends = 0;

            for (int other = 0; other < N; other++) {
                if (me == other) {
                    continue;
                }

                for (int grade = 0; grade < 5; grade++) {
                    if (arr[me][grade] == arr[other][grade]) {
                        friends++;
                        break;
                    }
                }
            }

            answer[me] = friends;
        }

        int maxFriends = Arrays.stream(answer).max().getAsInt();

        for (int i = 0; i < N; i++) {
            if (answer[i] == maxFriends) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}