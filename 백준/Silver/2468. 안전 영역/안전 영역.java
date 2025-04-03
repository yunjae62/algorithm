import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] graph;
    static int answer;
    static int height = 0, maxHeight = 1;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = stoi(st.nextToken());
                maxHeight = Math.max(maxHeight, graph[i][j]);
            }
        }

        while (height <= maxHeight) {
            visited = new boolean[N][N];
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && graph[i][j] > height) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            answer = Math.max(answer, count);
            height++;
        }

        System.out.println(answer);
    }

    static void bfs(int ox, int oy) {
        Queue<Node> q = new LinkedList<>();
        visited[ox][oy] = true;
        q.add(new Node(ox, oy));

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (graph[nx][ny] <= height) {
                    continue;
                }

                visited[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }
    }

    static class Node {

        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}