import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int W, H, N, M;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = stoi(st.nextToken());
        W = stoi(st.nextToken());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        int height = (H - 1) / (N + 1) + 1;
        int width = (W - 1) / (M + 1) + 1;

        System.out.print(height * width);
    }
}
