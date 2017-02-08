package problems;

/**
 * Created by fsantos on 1/9/17.
 */
public class Prob72 {
    /*
    Stock Buy Sell to Maximize Profit

    {100, 180, 260, 310, 40, 535, 695}
      buy
          80
               160
                    210
                         -60
                             435
                                  595


     */

    public static int maxProfitable(int[] prices, int B) {
        int maxProf = Integer.MIN_VALUE;

        int tempProf = 0;

        for (int i = B + 1; i < prices.length; i++) {
            tempProf = prices[i] - prices[B];
            tempProf += maxProfitable(prices, i + 1);
            maxProf = Math.max(tempProf, maxProf);
        }

        return maxProf;
    }

    public static void main(String[] args) {
        System.out.println(maxProfitable(new int[]{100, 180, 260, 310, 40, 535, 695}, 0));
    }
}
