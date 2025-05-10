import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int H, W;
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = stoi(st.nextToken());
        W = stoi(st.nextToken());

        for (int i = 0; i < H; i++) {
            String row = br.readLine();
            int minutes = -1;

            for (int j = 0; j < W; j++) {
                char sky = row.charAt(j);

                if (sky == 'c') {
                    sb.append("0").append(" ");
                    minutes = 1;
                    continue;
                }

                sb.append(minutes > -1 ? minutes++ : minutes).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}