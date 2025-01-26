import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, years;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = stoi(st.nextToken());
            }
        }

        while (true) {
            int count = 0;
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && graph[i][j] != 0) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            if (count == 0) {
                System.out.println(0);
                return;
            } else if (count >= 2) {
                System.out.println(years);
                return;
            }

            years++;
        }
    }

    static void bfs(int ox, int oy) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(ox, oy));
        visited[ox][oy] = true;
        List<Node> list = new ArrayList<>();

        while (!q.isEmpty()) {
            Node now = q.poll();
            int seaCount = 0;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (!visited[nx][ny])) {
                    if (graph[nx][ny] != 0) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny));
                    } else {
                        seaCount++;
                    }
                }
            }

            list.add(new Node(now.x, now.y, Math.max(0, graph[now.x][now.y] - seaCount)));
        }

        for (Node iceberg : list) {
            graph[iceberg.x][iceberg.y] = iceberg.after;
        }
    }

    static class Node {

        int x, y, after;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int after) {
            this.x = x;
            this.y = y;
            this.after = after;
        }
    }
}
