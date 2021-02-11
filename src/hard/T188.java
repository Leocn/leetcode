package hard;

/**
 * @Description: 最多k笔交易的最大利润
 * @Author: Leon
 * @Date: 2021/2/5
 */
public class T188 {
    public static int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if(length == 0) {return 0;}
        k = Math.min(k, length / 2+1);
        int[][][] aa = new int[length][2][k+1];
        for (int i = 1; i <= k ; i++) {
            aa[0][1][i] = -1 * prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= k ; j++) {
                aa[i][1][j] = Math.max(aa[i-1][1][j], aa[i-1][0][j-1]-prices[i]);
                aa[i][0][j] = Math.max(aa[i-1][0][j], aa[i-1][1][j]+prices[i]);
            }
        }
        return aa[length-1][0][k];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{3,4,1}));
        System.out.println(maxProfit(2, new int[]{2,3,2,6,5,0,3}));
    }
}
