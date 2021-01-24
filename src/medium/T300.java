package medium;


/**
 * @Description: 最长递增子序列
 * @Author: Leon
 * @Tag: @动态规划
 * @Date: 2021/1/23
 */
public class T300 {


    /**
     * f(k) 以nums(k)为结尾的最长递增子字符串长度
     * f(k) = max { f(m) | nums[m] < nums[k] }
     * dp(n) = max{ f(k) | k = 0...n}
     * */
    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] nArray = new int[length];
        nArray[0]=1;
        int size =1;
        for(int i = 1; i < length; i++){
            int ts = 1;
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]){
                    ts = Math.max(ts,nArray[j]+1 );
                }
            }
            nArray[i] = ts;
            size = Math.max(size, ts);
        }
        return size;
    }


    /**
     * 二分法 @TODO
     * */

//    public static int lengthOfLIS2(int[] nums) {
//
//    }


    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1,2,3,4,5,6,7,8,9,10}));
        System.out.println(lengthOfLIS(new int[]{10,9,8,7,6,5,4}));
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));




    }

}
