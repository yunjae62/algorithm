import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, answer = 1, maxHeight;
    static int[] arr = new int[N];

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stoi(br.readLine());
        }

        maxHeight = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > maxHeight) {
                answer++;
                maxHeight = arr[i];
            }
        }

        System.out.println(answer);
    }
}
