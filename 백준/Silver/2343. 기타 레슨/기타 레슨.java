import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        int left = Arrays.stream(arr).max().getAsInt();
        int right = Arrays.stream(arr).sum();

        // 블루레이 크기를 X축, 해당 크기로 나눠진 블루레이 개수를 Y축이라고 할 때, Y값이 M이 되는 최소 X값
        // lower bound

        while (left < right) {
            int mid = (left + right) / 2;

            int total = 0;
            int count = 1;
            for (int x : arr) {
                if (total + x > mid) {
                    count++;
                    total = x;
                } else {
                    total += x;
                }
            }

            if (count > M) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left);
    }
}