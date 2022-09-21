package algorithm.dfs;

// url:https://leetcode.cn/problems/k-similar-strings/solution/zhua-wa-mou-si-by-muse-77-b79a/
public class StringSimilarity {

    int result=Integer.MAX_VALUE;
    public static void main(String[] args) {

    }

    public int kSimilarity(String s1,String s2){
        return execute(s1.toCharArray(),s2.toCharArray(),0,0);
    }

    public int execute(char[] s1,char[] s2,int start,int current){
        if(current>=result)return result;
        if(start==s1.length-1)return result=Math.min(current,result);

        for(int i=start;i<s1.length;i++){
            if(s1[i]!=s2[i]){
                for(int j=i+1;j<s2.length;j++){
                    // 如果S2准备拿来交换的位置的字母已经与S1相同就不动
                    if(s2[j]==s1[i]&&s2[j]!=s1[j]){
                        swap(s2,i,j);
                        execute(s1,s2,i+1,current+1);
                        swap(s2,i,j);
                        if(s2[i]==s1[j])break;
                    }
                }
                return result;
            }
        }
        return result=Math.min(current,result);
    }

    public void swap(char[] sc,int i,int j){
        char tmp=sc[i];
        sc[i]=sc[j];
        sc[j]=tmp;
    }
}
