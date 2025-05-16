import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Point> cctvList = new ArrayList<>();

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

                if (0 < graph[i][j] && graph[i][j] < 6) {
                    cctvList.add(new Point(i, j));
                }
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (depth == cctvList.size()) {
            int count = 0;

            for (int[] row : graph) {
                for (int x : row) {
                    if (x == 0) {
                        count++;
                    }
                }
            }

            answer = Math.min(answer, count);
            return;
        }

        Point now = cctvList.get(depth);

        for (int i = 0; i < 4; i++) {
            seeCCTV(now, graph[now.x][now.y], i, true);
            dfs(depth + 1);
            seeCCTV(now, graph[now.x][now.y], i, false);
        }
    }

    static void seeCCTV(Point p, int type, int dir, boolean down) {
        if (type == 1) {
            see(p, dir, down);
        } else if (type == 2) {
            see(p, dir, down);
            see(p, (dir + 2) % 4, down);
        } else if (type == 3) {
            see(p, dir, down);
            see(p, (dir + 1) % 4, down);
        } else if (type == 4) {
            see(p, dir, down);
            see(p, (dir + 1) % 4, down);
            see(p, (dir + 2) % 4, down);
        } else {
            see(p, dir, down);
            see(p, (dir + 1) % 4, down);
            see(p, (dir + 2) % 4, down);
            see(p, (dir + 3) % 4, down);
        }
    }

    static void see(Point p, int dir, boolean down) {
        int nx = p.x + dx[dir];
        int ny = p.y + dy[dir];

        while ((0 <= nx && nx < N) && (0 <= ny && ny < M) && graph[nx][ny] != 6) {
            if (graph[nx][ny] <= 0) {
                graph[nx][ny] += (down ? -1 : +1);
            }

            nx += dx[dir];
            ny += dy[dir];
        }
    }

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}