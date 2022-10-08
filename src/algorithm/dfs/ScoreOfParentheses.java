package algorithm.dfs;

// url:https://leetcode.cn/problems/score-of-parentheses/submissions/
public class ScoreOfParentheses {

    int idx=0;
    char[] arr;
    public int scoreOfParentheses(String s) {
        arr=s.toCharArray();
        return dfs();
    }
    private int dfs(){
        int res=0;
        while(idx<arr.length&&arr[idx]=='('){
            idx++;
            if(arr[idx]==')')res+=1;
            else res+=dfs()*2;
            idx++;
        }
        return res;
    }
}
