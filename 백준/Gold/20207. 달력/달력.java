import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int area;
    static int[] days = new int[366];

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = stoi(st.nextToken());
            int e = stoi(st.nextToken());

            for (int day = s; day <= e; day++) {
                days[day]++;
            }
        }

        int width = 0;
        int maxHeight = 0;

        for (int day = 1; day <= 365; day++) {
            if (days[day] == 0) {
                area += width * maxHeight;
                width = 0;
                maxHeight = 0;
                continue;
            }

            width++;
            maxHeight = Math.max(maxHeight, days[day]);
        }

        area += width * maxHeight;
        System.out.println(area);
    }
}