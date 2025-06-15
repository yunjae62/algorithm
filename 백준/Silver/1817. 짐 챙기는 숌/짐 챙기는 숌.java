import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, box = 0;
    static int[] weights;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        weights = new int[N];

        if (N == 0) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = stoi(st.nextToken());
        }

        int nowBox = 0;

        for (int weight : weights) {
            if (nowBox + weight > M) {
                nowBox = weight;
                box++;
            } else {
                nowBox += weight;
            }
        }

        if (nowBox > 0) {
            box++;
        }

        System.out.println(box);
    }
}