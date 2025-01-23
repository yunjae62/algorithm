import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;
        int left = arr[0];
        int right = arr[N - 1];

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == 0) {
                left = arr[start];
                right = arr[end];
                break;
            }

            if (Math.abs(left + right) > Math.abs(sum)) {
                left = arr[start];
                right = arr[end];
            }

            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(left + " " + right);
    }
}