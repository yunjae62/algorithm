import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static int[] arr;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        S = stoi(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int right = 0;
        int total = arr[right];

        for (int left = 0; left < N; left++) {
            while (right < N && total < S) {
                right++;
                if (right != N) {
                    total += arr[right];
                }
            }

            if (right == N) {
                break;
            }

            min = Math.min(min, right - left + 1);
            total -= arr[left];
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
