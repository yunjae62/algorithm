import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            char[] s = st.nextToken().toCharArray();
            char[] t = st.nextToken().toCharArray();

            int idx = 0;

            for (char ch : t) {
                if (idx < s.length && ch == s[idx]) {
                    idx++;
                }
            }

            sb.append(idx == s.length ? "Yes" : "No").append("\n");
        }

        System.out.println(sb);
    }
}
