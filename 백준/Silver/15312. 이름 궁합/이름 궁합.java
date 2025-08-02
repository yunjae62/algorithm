import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final int[] arr = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String A = scn.nextLine();
        String B = scn.nextLine();

        int len = A.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int aCount = A.charAt(i) - 'A';
            list.add(arr[aCount]);
            int bCount = B.charAt(i) - 'A';
            list.add(arr[bCount]);
        }

        while (list.size() > 2) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                int x = list.get(i) + list.get(i + 1);
                temp.add(x % 10);
            }
            list = temp;
        }

        System.out.println(list.get(0) + "" + list.get(1));
    }
}
