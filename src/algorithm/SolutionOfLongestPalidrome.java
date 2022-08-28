package algorithm;

import java.io.*;

public class SolutionOfLongestPalidrome {


    public String longestPalidrome(String s){
        StringBuilder sb = new StringBuilder();
        sb.append('b');
        sb.append('+');


        int len=s.length();
        if(len < 2){
            return s;
        }

        int maxLen=1;int begin=0;
        boolean[][] dp=new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }

        char[] sarray=s.toCharArray();

        for(int sStrLen=2;sStrLen<=len;sStrLen++){
            // enum left side
            for(int left=0;left<len;left++){
                // sure right side
                int right=sStrLen+left-1;
                // break while right side across totol side
                if(right>=len){
                    break;
                }

                if(sarray[left] != sarray[right]){
                    dp[left][right] = false;
                } else {
                    // 这里有个错，猜猜看是什么？
                    dp[left][right]=dp[left+1][right-1];
                }

                if(dp[left][right]&&right-left+1>maxLen){
                    maxLen=right-left+1;
                    begin=left;
                }
            }
        }

        return s.substring(begin, begin+maxLen);
    }

}
