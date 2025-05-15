import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer;
    static Robot robot;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] graph;
    static boolean[][] cleaned;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = stoi(st.nextToken());
        int c = stoi(st.nextToken());
        int d = stoi(st.nextToken());

        graph = new int[N][M];
        cleaned = new boolean[N][M];
        robot = new Robot(r, c, d);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = stoi(st.nextToken());
            }
        }

        while (true) {
            if (!cleaned[robot.x][robot.y]) {
                cleaned[robot.x][robot.y] = true;
                answer++;
                continue;
            }

            boolean isClean = true;

            for (int i = 0; i < 4; i++) {
                int nx = robot.x + dx[i];
                int ny = robot.y + dy[i];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (graph[nx][ny] == 0) && (!cleaned[nx][ny])) {
                    isClean = false;
                }
            }

            if (!isClean) {
                robot.d = (robot.d - 1 + 4) % 4;

                int nx = robot.x + dx[robot.d];
                int ny = robot.y + dy[robot.d];

                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (graph[nx][ny] == 0) && (!cleaned[nx][ny])) {
                    robot = new Robot(nx, ny, robot.d);
                }
                continue;
            }

            int backD = (robot.d + 2) % 4;

            int nx = robot.x + dx[backD];
            int ny = robot.y + dy[backD];

            if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (graph[nx][ny] == 0)) {
                robot = new Robot(nx, ny, robot.d);
                continue;
            }

            break;
        }

        System.out.println(answer);
    }

    static class Robot {

        int x, y, d;

        public Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}