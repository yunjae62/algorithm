import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, maxCount;
    static List<Integer> maxList;
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 1; i <= N; i++) {
            int first = N;
            int second = i;
            List<Integer> list = new ArrayList<>(List.of(first, second));

            while (first - second >= 0) {
                int temp = first;
                first = second;
                second = temp - second;
                list.add(second);
            }

            if (maxCount < list.size()) {
                maxCount = Math.max(maxCount, list.size());
                maxList = list;
            }
        }

        sb.append(maxCount).append("\n");
        for (Integer x : maxList) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}