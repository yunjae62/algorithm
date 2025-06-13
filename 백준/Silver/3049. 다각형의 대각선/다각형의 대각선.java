import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int intersections = N * (N - 1) * (N - 2) * (N - 3) / 24;
        System.out.println(intersections);
    }
}