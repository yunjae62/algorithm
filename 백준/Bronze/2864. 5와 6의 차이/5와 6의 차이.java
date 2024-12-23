import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int min, max;
    static String A, B;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken();
        B = st.nextToken();

        min = stoi(A.replaceAll("6", "5")) + stoi(B.replaceAll("6", "5"));
        max = stoi(A.replaceAll("5", "6")) + stoi(B.replaceAll("5", "6"));

        System.out.println(min + " " + max);
    }
}
