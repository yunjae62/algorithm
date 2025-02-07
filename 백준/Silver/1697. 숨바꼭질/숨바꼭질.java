import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100_000;
    static int N, K;
    static boolean[] visited = new boolean[MAX + 1];

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));
        visited[N] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.n == K) {
                System.out.println(now.count);
                return;
            }

            if (isValid(now.n - 1)) {
                q.add(new Node(now.n - 1, now.count + 1));
                visited[now.n - 1] = true;
            }

            if (isValid(now.n + 1)) {
                q.add(new Node(now.n + 1, now.count + 1));
                visited[now.n + 1] = true;
            }

            if (isValid(2 * now.n)) {
                q.add(new Node(2 * now.n, now.count + 1));
                visited[2 * now.n] = true;
            }
        }
    }

    static boolean isValid(int x) {
        return 0 <= x && x <= MAX && !visited[x];
    }

    static class Node {

        int n, count;

        public Node(int n, int count) {
            this.n = n;
            this.count = count;
        }
    }
}
