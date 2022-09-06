package algorithm.mathematicallaws;

// url:https://leetcode.cn/problems/beautiful-arrangement-ii/
public class BeautifulArray {

    public int[] constructArray(int n, int k) {
        int interval=k;
        int[] ans=new int[n];
        ans[0]=1;
        // 使用前k+1个数构造k差值序列
        for(int i=1;i<=k;i++){
            ans[i]=(i%2==1)?ans[i-1]+interval:ans[i-1]-interval;
            interval--;
        }
        for(int i=k+1;i<n;i++){
            ans[i]=i+1;
        }
        return ans;
    }
}
