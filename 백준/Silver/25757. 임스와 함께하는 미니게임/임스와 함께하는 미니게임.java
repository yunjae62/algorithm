import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static String game;
    static Set<String> people = new HashSet<>();
    static Map<String, Integer> minPeople = Map.of("Y", 2, "F", 3, "O", 4);

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        game = st.nextToken();

        for (int i = 0; i < N; i++) {
            people.add(br.readLine());
        }

        int min = minPeople.get(game) - 1;

        System.out.println(people.size() / min);
    }
}