import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, D, answer;
    static List<Road> roads = new ArrayList<>();
    static Queue<Integer> pq = new PriorityQueue<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int h = stoi(st.nextToken());
            int o = stoi(st.nextToken());

            roads.add(new Road(Math.min(h, o), Math.max(h, o)));
        }

        D = stoi(br.readLine());

        Collections.sort(roads);

        for (Road road : roads) {
            if (D < road.end - road.start) {
                continue;
            }

            pq.add(road.start);

            while (!pq.isEmpty() && pq.peek() + D < road.end) {
                pq.poll();
            }

            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);
    }

    static class Road implements Comparable<Road> {

        int start, end;

        public Road(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Road o) {
            if (this.end == o.end) {
                return Integer.compare(this.start, o.start);
            }
            return Integer.compare(this.end, o.end);
        }
    }
}