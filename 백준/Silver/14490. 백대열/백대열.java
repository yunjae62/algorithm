import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(":");
        int n = stoi(line[0]);
        int m = stoi(line[1]);
        
        int gcd = gcd(n, m);
        
        System.out.println((n / gcd) + ":" + (m / gcd));
    }

    private static int gcd(int n, int m) {
        int min = Math.min(n, m);
        int max = Math.max(n, m);

        while (min > 0) {
            int temp = min;
            min = max % min;
            max = temp;
        }

        return max;
    }
}