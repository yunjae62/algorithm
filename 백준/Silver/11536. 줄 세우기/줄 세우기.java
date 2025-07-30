import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        boolean isInc = true;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) >= 0) {
                isInc = false;
                break;
            }
        }

        if (isInc) {
            System.out.println("INCREASING");
            return;
        }

        boolean isDec = true;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) <= 0) {
                isDec = false;
                break;
            }
        }

        if (isDec) {
            System.out.println("DECREASING");
            return;
        }

        System.out.println("NEITHER");
    }
}
