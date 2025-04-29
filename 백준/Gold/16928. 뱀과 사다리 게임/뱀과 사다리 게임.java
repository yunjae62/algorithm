import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static Map<Integer, Integer> ladders;
    static Map<Integer, Integer> snakes;
    static boolean[] visited = new boolean[101];

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        ladders = new HashMap<>(N);
        snakes = new HashMap<>(M);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladders.put(stoi(st.nextToken()), stoi(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snakes.put(stoi(st.nextToken()), stoi(st.nextToken()));
        }

        System.out.println(bfs(1));
    }

    static int bfs(int start) {
        Queue<Player> q = new LinkedList<>();
        q.add(new Player(1, 0));
        visited[1] = true;

        while (!q.isEmpty()) {
            Player now = q.poll();

            if (now.x == 100) {
                return now.cnt;
            }

            if (ladders.containsKey(now.x)) {
                now.x = ladders.get(now.x);
                visited[now.x] = true;
            }

            if (snakes.containsKey(now.x)) {
                now.x = snakes.get(now.x);
                if (visited[now.x]) {
                    continue;
                }
                visited[now.x] = true;
            }

            for (int next = now.x + 1; next <= now.x + 6; next++) {
                if (next > 100) {
                    break;
                }

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Player(next, now.cnt + 1));
                }
            }
        }

        return 0;
    }

    static class Player {

        int x, cnt;

        public Player(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}