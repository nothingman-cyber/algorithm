package algorithm.dynamicproject;

// url:https://leetcode.cn/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
// 这个题无法用暴力解法，会超时间
public class MaxSubArray {


    public int dpMethod(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public int maxSubArray_violent(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[][] dp=new int[nums.length+1][nums.length+1];
        int res=Integer.MIN_VALUE;
        for(int i=1;i<nums.length+1;i++){
            for(int j=1;j<nums.length+1;j++){
                if(i==j){
                    dp[i][j]=nums[i-1];
                    res=Math.max(res,dp[i][j]);
                }
                if(i<j&&i<=j-1){
                    dp[i][j]=dp[i][j-1]+nums[j-1];
                    res=Math.max(res,dp[i][j]);
                }

            }
        }
        return res;
    }
}
