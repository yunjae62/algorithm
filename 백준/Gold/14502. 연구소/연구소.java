import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer;
    static int[][] graph;
    static List<Node> virusList = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

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

                if (graph[i][j] == 2) {
                    virusList.add(new Node(i, j));
                }
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (depth == 3) {
            int[][] tempGraph = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    tempGraph[i][j] = graph[i][j];
                }
            }

            for (Node virus : virusList) {
                bfs(virus, tempGraph);
            }

            int safeArea = 0;
            for (int[] row : tempGraph) {
                for (int x : row) {
                    if (x == 0) {
                        safeArea++;
                    }
                }
            }

            answer = Math.max(answer, safeArea);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(depth + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    static void bfs(Node start, int[][] graph) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (!(0 <= nx && nx < N)) {
                    continue;
                }
                if (!(0 <= ny && ny < M)) {
                    continue;
                }
                if (graph[nx][ny] != 0) {
                    continue;
                }

                graph[nx][ny] = 2;
                q.add(new Node(nx, ny));
            }
        }
    }

    static class Node {

        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}