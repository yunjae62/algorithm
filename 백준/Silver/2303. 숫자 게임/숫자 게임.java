import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, maxNum, maxPerson;
    static int[] arr = new int[5];

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[j] = stoi(st.nextToken());
            }

            int max = 0;

            for (int first = 0; first < 3; first++) {
                for (int second = first + 1; second < 4; second++) {
                    for (int third = second + 1; third < 5; third++) {
                        int total = arr[first] + arr[second] + arr[third];
                        max = Math.max(max, total % 10);
                    }
                }
            }

            if (max >= maxNum) {
                maxNum = max;
                maxPerson = i;
            }
        }

        System.out.println(maxPerson);
    }
}