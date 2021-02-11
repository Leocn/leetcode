package easy;

/**
 * @Description: 买卖股票的最佳时机，多次交易
 * @Author: Leon
 * @Date: 2021/2/5
 */
public class T122 {
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] aa = new int[length][2];
        //没有股票
        aa[0][0] = 0;
        //有股票
        aa[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            aa[i][0] = Math.max(aa[i-1][0], aa[i-1][1]+ prices[i]);
            aa[i][1] = Math.max(aa[i-1][1], aa[i-1][0]- prices[i]);
        }
        return aa[length-1][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
