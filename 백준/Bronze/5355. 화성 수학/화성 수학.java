import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static StringBuilder sb = new StringBuilder();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            double num = Double.parseDouble(st.nextToken());

            while (st.hasMoreTokens()) {
                String operator = st.nextToken();

                if (operator.equals("@")) {
                    num *= 3;
                } else if (operator.equals("%")) {
                    num += 5;
                } else if (operator.equals("#")) {
                    num -= 7;
                }
            }

            sb.append(String.format("%.2f%n", num));
        }

        System.out.println(sb);
    }
}