import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Point king, stone;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String kingInput = st.nextToken();
        king = new Point(8 - (kingInput.charAt(1) - '0'), kingInput.charAt(0) - 'A');

        String stoneInput = st.nextToken();
        stone = new Point(8 - (stoneInput.charAt(1) - '0'), stoneInput.charAt(0) - 'A');

        N = stoi(st.nextToken());

        while (N-- > 0) {
            String dir = br.readLine();

            Point nextKing = move(king, dir);

            if (nextKing.equals(king)) {
                continue;
            }

            if (nextKing.equals(stone)) {
                Point nextStone = move(stone, dir);

                if (nextStone.equals(stone)) {
                    continue;
                }

                king = nextKing;
                stone = nextStone;
            } else {
                king = nextKing;
            }
        }

        System.out.println(king);
        System.out.println(stone);
    }

    static Point move(Point p, String dir) {
        int nx = p.x;
        int ny = p.y;

        if (dir.equals("R")) {
            ny++;
        } else if (dir.equals("L")) {
            ny--;
        } else if (dir.equals("B")) {
            nx++;
        } else if (dir.equals("T")) {
            nx--;
        } else if (dir.equals("RT")) {
            nx--;
            ny++;
        } else if (dir.equals("LT")) {
            nx--;
            ny--;
        } else if (dir.equals("RB")) {
            nx++;
            ny++;
        } else if (dir.equals("LB")) {
            nx++;
            ny--;
        }

        if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) {
            return p;
        }

        return new Point(nx, ny);
    }


    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return ((char) (y + 'A')) + String.valueOf(8 - x);
        }
    }
}