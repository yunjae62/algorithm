import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long[] arr;
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new long[N];
        int i = 0;

        while (st.hasMoreTokens()) {
            arr[i++] = reverseParse(st.nextToken());
        }

        while (i < N) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                arr[i++] = reverseParse(st.nextToken());
            }
        }

        Arrays.sort(arr);

        for (long x : arr) {
            sb.append(x).append("\n");
        }

        System.out.println(sb);
    }

    static long reverseParse(String str) {
        long num = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            num = num * 10 + (str.charAt(i) - '0');
        }
        return num;
    }
}