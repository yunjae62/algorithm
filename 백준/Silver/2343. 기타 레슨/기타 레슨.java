import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] times;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        times = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = stoi(st.nextToken());
        }

        int left = Arrays.stream(times).max().getAsInt();
        int right = Arrays.stream(times).sum();

        while (left < right) {
            int mid = (left + right) / 2;

            int count = 1;
            int temp = 0;

            for (int i = 0; i < N - 1; i++) {
                temp += times[i];

                if (temp + times[i + 1] > mid) {
                    count++;
                    temp = 0;
                }
            }

            if (count <= M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}