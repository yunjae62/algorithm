import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int prevStart = Integer.MIN_VALUE;
    static int prevEnd = Integer.MIN_VALUE;
    static int totalLines;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int nowStart = stoi(st.nextToken());
            int nowEnd = stoi(st.nextToken());

            if (prevEnd < nowStart) {
                totalLines += prevEnd - prevStart;
                prevStart = nowStart;
                prevEnd = nowEnd;
            } else if (prevEnd < nowEnd) {
                prevEnd = nowEnd;
            }
        }

        totalLines += prevEnd - prevStart;
        System.out.println(totalLines);
    }
}