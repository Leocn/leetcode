package medium;

/**
 * @Description: 最佳买卖股票时机含冷冻期
 * @Author: Leon
 * @Date: 2021/2/11
 */
public class T309 {
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if(length==0 || length ==1 ) return 0;
        if(length==2 ) return Math.max(prices[1]-prices[0],0);
        int[][] aa = new int[length][3];
        aa[0][1] = -1 * prices[0];
        aa[1][1] = Math.max(aa[0][1],-1 * prices[1]);
        aa[1][0] = Math.max(prices[1]-prices[0],0);
        for (int i = 2; i < length; i++) {
            aa[i][0] = Math.max(aa[i-1][0],aa[i-1][1]+prices[i] );
            aa[i][1] = Math.max(aa[i-1][1], aa[i-1][2]-prices[i]);
            aa[i][2] = Math.max(aa[i-1][2], aa[i-1][0]);
        }

        return aa[length-1][0];

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }
}
