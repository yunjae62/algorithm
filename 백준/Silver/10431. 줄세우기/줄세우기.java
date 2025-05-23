import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int P;
    static int[] line = new int[20];
    static int[] heights = new int[20];
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = stoi(st.nextToken());

        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            sb.append(stoi(st.nextToken())).append(" ");
            for (int i = 0; i < 20; i++) {
                heights[i] = stoi(st.nextToken());
            }

            int move = 0;
            line[0] = heights[0];

            for (int i = 1; i < 20; i++) {
                int height = heights[i];
                int idx = i;

                while (idx > 0 && line[idx - 1] > height) {
                    line[idx] = line[idx - 1];
                    idx--;
                    move++;
                }

                line[idx] = height;
            }

            sb.append(move).append("\n");
        }

        System.out.println(sb);
    }
}