package medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description: 最长的斐波那契子序列的长度
 * @Author: Leon
 * @Date: 2021/1/25
 */
public class T873 {
    /**
     * 最大值为m,下一列为n的斐波那契长度 dp(m)(n)
     * 适用于不是自增长的，数字小的数列
     * */
//    public static int lenLongestFibSubseq(int[] arr) {
//        int[][] tt = new int[1000][1000];
//        int sum = 2;
//        int length = arr.length;
//        for(int i = 1; i<length; i++){
//            int mm = 1;
//            for(int j = 0; j<i; j++ ){
//                if(arr[i]>arr[j]){
//                    tt[arr[i]][arr[j]]  = Math.max(2,tt[arr[j]][arr[i]-arr[j]]+1);
//                    mm =  Math.max(mm,tt[arr[i]][arr[j]]);
//                }
//            }
//            sum =  Math.max(sum,mm);
//        }
//        if(sum==2) {sum=0;}
//        return sum;
//    }


    /**
     * 时间过长
     * */
//    public static int lenLongestFibSubseq(int[] arr) {
//        int [][] dp = new int[1000][1000][1000];
//
//        int maxmax = 0;
//        for (int i = 2; i < arr.length; i++) {
//            int ss = 0;
//            for(int k = 1; k<i; k++){
//                int hh = 0;
//                for(int j = 0; j<k; j++){
//                    if(arr[i] == arr[k] + arr[j]){
//                        dp[i][k] = Math.max( 3,dp[k][j]+1);
//                    }
//                    hh = Math.max(dp[i][k],hh);
//                }
//                ss = Math.max(ss,hh);
//            }
//            maxmax = Math.max(ss,maxmax);
//
//        }
//        return maxmax;
//    }



//    public static int lenLongestFibSubseq(int[] arr) {
//        int length = arr.length;
//        int[][] tt = new int[length][length];
//        HashMap<Integer,Integer> hs = new HashMap<>();
//
//        for (int i = 0; i < length ; i++) {
//            hs.put(arr[i],i);
//        }
//        int sum = 2;
//        for(int i = 1; i<length; i++){
//            int mm = 1;
//            for(int j = 0; j<i; j++ ){
//                tt[i][j] = 2;
//                if(hs.containsKey(arr[i]-arr[j]) && arr[i]-arr[j]<arr[j]){
//                    tt[i][j] = tt[hs.get(arr[j])][hs.get(arr[i]-arr[j])]+1;
//                }
//                mm = Math.max(tt[i][j],mm);
//            }
//            sum =  Math.max(sum,mm);
//        }
//        if(sum==2) {sum=0;}
//        return sum;
//    }

    /**
     * 时间快
     * */
    public static int lenLongestFibSubseq(int[] arr) {
        int length = arr.length;
        int[][] tt = new int[length][length];
        HashMap<Integer,Integer> hs = new HashMap<>();

        for (int i = 0; i < length ; i++) {
            Arrays.fill(tt[i],2);
            hs.put(arr[i],i);
        }
        int sum = 2;
        for(int i = 1; i<length; i++){
            int mm = 1;
            int j = i-1;
            while(j>=0 && arr[i]-arr[j]<arr[j]){
                if(hs.containsKey(arr[i]-arr[j])){
                    tt[i][j] = tt[hs.get(arr[j])][hs.get(arr[i]-arr[j])]+1;
                }
                mm =  Math.max(mm,tt[i][j]);
                j--;
            }
            sum =  Math.max(sum,mm);
        }
        if(sum==2) {sum=0;}
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
    }
}
