package algorithm.backtracking;

// url:https://leetcode.cn/problems/unique-binary-search-trees/
public class CountAllBSTOverRange {

    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int total=2;total<=n;total++){
            for(int root=1;root<=total;root++){
                dp[total]+=dp[root-1]*dp[total-root];
            }
        }
        return dp[n];
    }
}
