import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, size = 2, times, fishes, babyX, babyY;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

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
                int x = stoi(st.nextToken());
                graph[i][j] = x;

                if (x == 9) {
                    babyX = i;
                    babyY = j;
                    graph[i][j] = 0;
                }
            }
        }

        while (true) {
            Fish res = bfs();

            if (res.moves == 0) {
                break;
            }

            times += res.moves;
            babyX = res.x;
            babyY = res.y;

            if (size <= fishes) {
                fishes -= size;
                size++;
            }
        }

        System.out.println(times);
    }

    static Fish bfs() {
        visited = new boolean[N][N];
        visited[babyX][babyY] = true;
        Queue<Fish> q = new PriorityQueue<>();
        q.add(new Fish(babyX, babyY, 0));

        while (!q.isEmpty()) {
            Fish now = q.poll();

            if (0 < graph[now.x][now.y] && graph[now.x][now.y] < size) {
                graph[now.x][now.y] = 0;
                fishes++;
                return now;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (!(0 <= nx && nx < N)) {
                    continue;
                }
                if (!(0 <= ny && ny < N)) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (graph[nx][ny] > size) {
                    continue;
                }

                visited[nx][ny] = true;
                q.add(new Fish(nx, ny, now.moves + 1));
            }
        }

        return new Fish(babyX, babyY, 0);
    }

    static class Fish implements Comparable<Fish> {

        int x, y, moves;

        public Fish(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.moves != o.moves) {
                return Integer.compare(this.moves, o.moves);
            }
            if (this.x != o.x) {
                return Integer.compare(this.x, o.x);
            }
            return Integer.compare(this.y, o.y);
        }
    }
}