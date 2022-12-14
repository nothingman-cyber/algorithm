package algorithm;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println("最长回文串");
    }

    public String longestPalindrome(String s) {
        int a=Integer.MAX_VALUE;
        List<Integer> test = new ArrayList<>();
        test.size();
        int[] aaa =new int[3];
        int aaaa = aaa.length;
        int len = s.length();
        if(len<2){
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len]; //默认全false
        char[] charArray = s.toCharArray();

        for(int i = 0;i < len;i++) {
            dp[i][i] = true;
        }

        for(int j = 1;j < len;j++) {
            for(int i = 0;i < j;i++) {
                if(charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if(j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }
}
