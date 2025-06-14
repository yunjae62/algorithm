import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, count;
    static boolean[] visited;
    static List<Integer>[] graph;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(br.readLine());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        visited[1] = true;
        List<Integer> friends = new ArrayList<>();
        
        for (Integer friend : graph[1]) {
            friends.add(friend);
            visited[friend] = true;
            count++;
        }

        for (Integer friend : friends) {
            for (Integer friendOfFriend : graph[friend]) {
                if (!visited[friendOfFriend]) {
                    visited[friendOfFriend] = true;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}