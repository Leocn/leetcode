package medium;

/**
 * @Description: 一个字符串有多少回文子串
 * @Author: Leon
 * @Tag: @动态规划
 * @Date: 2021/1/23
 */
public class T647 {

    /**
     * 方法1，穷举，计算太慢
     *
     * */
    public static int countSubstrings1(String s) {
        if(s.length()==1) {return 1;}

        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            sum += countString(s.substring(i));
        }
        return sum;

    }


    public static int countString(String h){
        int sum = 0;
        if(h.length()==1) return 1;
        for (int i = 1; i < h.length()+1; i++) {
            int count = 0;
            String t = h.substring(0,i);
            System.out.println(t);
            count += checkString(t);
            sum += count;
        }
        return sum;
    }


    public static int  checkString(String t){
        if(t.length()==1) {return 1;}
        int length = t.length();
        int count = 1;
        for (int i = 0; i < length/2; i++) {
            char[] tArray = t.toCharArray();
            while (tArray[i]!=tArray[length-i-1]) {
                count = 0;
                break;
            }
        }
        return count;
    }


    /**
     * 方法2 DP(n) = DP(n-1) + {包含第n个字符的字符串的回文串个数}
     * */

    public static int countSubstrings2(String s) {
        int len = s.length();
        if(len==1) return 1;

        int[]table = new int[len];
        char[] strChar = s.toCharArray();
        int sum = 1;
        for(int i = 1; i < len; i++){
            int subSum = table[i] = 1;

            for (int j = 0; j < i; j++) {
                int compare = strChar[j]==strChar[i]?1:0;
                if(i-j>1&&compare==1){
                    compare = table[j+1];
                }
                table[j] = compare;
                subSum += compare;
            }
            sum += subSum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings1("aaa") == 6);
        System.out.println(countSubstrings2("aaa") == 6);
    }

}
