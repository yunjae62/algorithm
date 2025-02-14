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

    static int N;
    static List<Meeting> meetings = new ArrayList<>();
    static Queue<Integer> rooms = new PriorityQueue<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());

            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings);

        for (Meeting meeting : meetings) {
            if (!rooms.isEmpty() && rooms.peek() <= meeting.start) {
                rooms.poll();
            }

            rooms.add(meeting.end);
        }

        System.out.println(rooms.size());
    }

    static class Meeting implements Comparable<Meeting> {

        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Meeting o) {
            if (this.start == o.start) {
                return Integer.compare(this.end, o.end);
            }

            return Integer.compare(this.start, o.start);
        }
    }
}
