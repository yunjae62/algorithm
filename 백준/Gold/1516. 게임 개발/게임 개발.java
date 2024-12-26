import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] indegree, times, totalTimes;
    static Queue<Integer> q = new LinkedList<>();
    static List<List<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        indegree = new int[N + 1];
        times = new int[N + 1];
        totalTimes = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int building = 1; building <= N; building++) {
            st = new StringTokenizer(br.readLine());
            times[building] = stoi(st.nextToken());

            while (st.hasMoreTokens()) {
                int prevBuilding = stoi(st.nextToken());

                if (prevBuilding == -1) {
                    break;
                }

                graph.get(prevBuilding).add(building);
                indegree[building]++;
            }
        }

        for (int building = 1; building <= N; building++) {
            if (indegree[building] == 0) {
                q.add(building);
                totalTimes[building] = times[building];
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (Integer next : graph.get(now)) {
                totalTimes[next] = Math.max(totalTimes[next], totalTimes[now] + times[next]);

                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(totalTimes[i]).append("\n");
        }

        System.out.println(sb);
    }
}
