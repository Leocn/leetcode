package easy;

/**
 * @Description: 买卖股票的最佳时机，单次交易
 * @Author: Leon
 * @Date: 2021/1/30
 */
public class T121 {
//    public static int maxProfit(int[] prices) {
//        int n = prices.length;
//        int min = prices[0];
//        int max = prices[0];
//        int sum = 0;
//        if(n == 1 ){return 0;}
//
//        for (int i = 1; i < n; i++) {
//            if(prices[i] > max){
//                max = prices[i];
//                sum = Math.max(sum, max-min);
//                continue;
//            }
//            if(prices[i]<min){
//                min = prices[i];
//                max = prices[i];
//            }
//
//        }
//        return sum;
//
//    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int sum = 0;
        if(n == 1 ){return 0;}

        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            sum = Math.max(sum, prices[i] - min);

        }
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
