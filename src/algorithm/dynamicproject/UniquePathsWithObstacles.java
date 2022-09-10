package algorithm.dynamicproject;

// url:https://leetcode.cn/problems/unique-paths-ii/submissions/
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int column=obstacleGrid.length,row=obstacleGrid[0].length;
        //column竖,row横
        int[][] dp=new int[column][row];
        if(obstacleGrid[0][0]==1){
            return 0;
        }else{
            dp[0][0]=1;
        }
        for(int i=0;i<column;i++){
            for(int j=0;j<row;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                int a=i-1>=0?dp[i-1][j]:0;
                int b=j-1>=0?dp[i][j-1]:0;
                dp[i][j]+=(a+b);
            }
        }
        return dp[column-1][row-1];
    }
}
