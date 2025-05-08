import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            N = stoi(st.nextToken());
            M = stoi(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int count = 0;
            Queue<Document> q = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                int priority = stoi(st.nextToken());
                q.add(new Document(priority, i == M));
            }

            while (true) {
                int maxPriority = q.stream().mapToInt(x -> x.priority).max().getAsInt();

                Document document = q.poll();

                if (document.priority == maxPriority) {
                    count++;
                    if (document.isTarget) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    q.add(document);
                }
            }
        }
    }

    static class Document {

        int priority;
        boolean isTarget;

        Document(int priority, boolean isTarget) {
            this.priority = priority;
            this.isTarget = isTarget;
        }
    }
}