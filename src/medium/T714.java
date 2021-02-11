package medium;

/**
 * @Description: 买卖股票的最佳时机含手续费
 * @Author: Leon
 * @Date: 2021/1/29
 */
public class T714 {
//    public static int maxProfit(int[] prices, int fee) {
//        int n = prices.length;
//        int[] tt = new int[2];
//        tt[1] = (-1) * prices[0];
//        if(n == 1 ){return 0;}
//
//        for (int i = 1; i < n; i++) {
//            tt[0] = Math.max(tt[0], tt[1]+prices[i]-fee );
//            tt[1] = Math.max(tt[1], tt[0]-prices[i]);
//
//            //TODO 为什么这两种部分一样
////            int a =  Math.max(tt[0], tt[1]+prices[i]-fee );
////            int b = Math.max(tt[1], tt[0]-prices[i]);
////
////            tt[0] = a;
////            tt[1] = b;
//
//        }
//        return tt[0];
//    }


    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int max = 0;
        int min = prices[0];
        if(n == 1 ){return 0;}

        for (int i = 1; i < n; i++) {
            if(prices[i]<min){
                min = prices[i];
            }else if(prices[i] > min + fee){
                max += prices[i] - min -fee;
                min = prices[i] - fee;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

}
