import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K, answer;
    static int[] arr;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = stoi(st.nextToken());
        }

        for (int i = 1; i <= String.valueOf(N).length(); i++) {
            dfs(0, i, "");
        }

        System.out.println(answer);
    }

    static void dfs(int depth, int maxDepth, String num) {
        if (depth == maxDepth) {
            int total = Integer.parseInt(num);
            if (total <= N) {
                answer = Math.max(answer, total);
            }
            return;
        }

        for (int next : arr) {
            dfs(depth + 1, maxDepth, num + next);
        }
    }
}