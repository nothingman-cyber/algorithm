package algorithm.greedyalgorithm;

import java.util.Arrays;

// https://leetcode.cn/problems/maximum-length-of-pair-chain/solution/
public class FindLongestChain {


    public int findLongestChain(int[][] pairs) {
        int curr=Integer.MIN_VALUE;
        int res=0;
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        for(int[] pair:pairs){
            if(curr<pair[0]){
                curr=pair[1];
                res++;
            }
        }
        return res;
    }
}
