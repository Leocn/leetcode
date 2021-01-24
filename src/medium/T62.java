package medium;

import com.sun.tools.javac.util.Assert;

/**
 * @Description: m*n格子,只能左到右，上到下，有多少走法？
 * @Tag: @动态规划
 * @Author: Leon
 * @Date: 2021/1/23
 */

public class T62 {
    /**
     * DP(m)(n) = DP(m-1)(n) + DP(m)(n-1)
     * 等于左侧和上侧位置的走法和
     * */
    public static int uniquePaths(int m, int n) {
        if(m==1||n==1) {return 1;}
        int[][] aa = new int[m][n];
        for(int i = 1; i< n ; i++){
            aa[0][i]=1;
            for(int j = 1; j< m ; j++){
                aa[j][0]=1;
                aa[j][i] = aa[j-1][i]+aa[j][i-1];
            }

        }
        return aa[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3) ==28);
    }

}
