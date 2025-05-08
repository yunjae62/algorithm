import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, one, count;
    static Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        one = stoi(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            pq.add(stoi(br.readLine()));
        }

        while (!pq.isEmpty() && one <= pq.peek()) {
            one++;
            count++;
            pq.add(pq.poll() - 1);
        }

        System.out.println(count);
    }
}