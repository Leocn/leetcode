package medium;

/**
 * @Description:
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * @Author: Leon
 * @Date: 2021/1/23
 */
public class T474 {

    /**
     * int[j][k][i] sum 数组表示前i个字符串最多有 j个 0 和 k 个 1的子集大小
     * 状态转移方程sum[j][k][i] = Math.max(sum[j-sum0][k-sum1][i-1]+1, sum[j][k][i-1]);
     * */

    /**
     * 三维数组
     * */
    public static int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] sum = new int[m+1][n+1][length+1];
        for (int i = 1; i <length+1; i++) {
            int subLength = strs[i-1].length();
            int sum0 = strs[i-1].replace("1","").length();
            int sum1  = subLength - sum0;
            System.out.println("=================");
            for(int j = 0; j<=m; j++){
                for (int k=0; k<=n; k++) {
                    if(j<sum0||k<sum1){
                        sum[j][k][i] = sum[j][k][i-1];
                        continue;
                    }

                    sum[j][k][i] = Math.max(sum[j-sum0][k-sum1][i-1]+1, sum[j][k][i-1]);
                    System.out.println("j-----"+j + "k ------"+k+"-------"+sum[j][k][i]);
                }
            }
        }
        return sum[m][n][length];
    }

    /**
     * 二维数组，比较时要用用--比较, 否则出错。
     * */
    public static int findMaxForm1(String[] strs, int m, int n) {


        int length = strs.length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < length; i++) {
            int subLength = strs[i].length();
            int sum0 = strs[i].replace("1", "").length();
            int sum1 = subLength - sum0;

            for (int j = m; j >= sum0; j--) {
                for (int k = n; k >= sum1; k--) {
                    sum[j][k] = Math.max(sum[j - sum0][k - sum1] + 1, sum[j][k]);
                    System.out.println("j-----" + j + "k ------" + k + "-------" + sum[j][k]);
                }
            }
            System.out.println(sum[m][n]);
        }
        return sum[m][n];
    }

    public static void main(String[] args) {
//        System.out.println( findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},4,3));
//        System.out.println( findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3));
//
//        System.out.println( findMaxForm(new String[]{"10", "0001", "111001", "0", "1"},10,10));

        System.out.println( findMaxForm(new String[]{"0111","110010","1","10","1100001111",
                "0","11110011","1","01000","010100",
                "11101","0","1001","0","00100","01011","10","1",
                "1111110","1","00","00001","110","0"},9,9));
//        System.out.println( findMaxForm(new String[]{"10", "1", "0"},99,99));
//        System.out.println( findMaxForm(new String[]{"10", "0", "1"},1,1));
//        System.out.println( findMaxForm(new String[]{ "1", "0"},1,1));
//        System.out.println( findMaxForm(new String[]{"111001"},5,3));

    }

}
