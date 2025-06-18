import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cash;
    static int[] prices = new int[14];

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cash = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            prices[i] = stoi(st.nextToken());
        }

        int bnpCash = cash;
        int bnpStock = 0;

        for (int price : prices) {
            int count = bnpCash / price;
            bnpStock += count;
            bnpCash -= price * count;
        }

        int timingCash = cash;
        int timingStock = 0;
        int upCount = 0;
        int downCount = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                upCount++;
                downCount = 0;
                if (upCount >= 3 && timingStock > 0) {
                    timingCash += timingStock * prices[i];
                    timingStock = 0;
                }
            } else if (prices[i] < prices[i - 1]) {
                downCount++;
                upCount = 0;
                if (downCount >= 3 && timingCash >= prices[i]) {
                    int buyCount = timingCash / prices[i];
                    timingStock += buyCount;
                    timingCash -= buyCount * prices[i];
                }
            } else {
                upCount = downCount = 0;
            }
        }

        int lastPrice = prices[13];
        int bnpAsset = bnpCash + bnpStock * lastPrice;
        int timingAsset = timingCash + timingStock * lastPrice;

        if (bnpAsset > timingAsset) {
            System.out.println("BNP");
        } else if (bnpAsset < timingAsset) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}