package algorithm.dynamicproject;

// url:https://leetcode.cn/problems/minimum-path-sum/
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int column=grid.length,row=grid[0].length;
        int[][] dp=new int[column][row];
        dp[0][0]=grid[0][0];
        for(int i=0;i<column;i++){
            for(int j=0;j<row;j++){
                if(i==0&&j==0){
                    continue;
                }
                int a=i-1>=0?dp[i-1][j]+grid[i][j]:200;
                int b=j-1>=0?dp[i][j-1]+grid[i][j]:200;
                dp[i][j]=Math.min(a,b);
            }
        }
        return dp[column-1][row-1];
    }
}
