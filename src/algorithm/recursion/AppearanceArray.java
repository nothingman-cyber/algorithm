package algorithm.recursion;

// url:https://leetcode.cn/problems/count-and-say/submissions/
public class AppearanceArray {

    public String countAndSay(int n) {
        StringBuilder res= new StringBuilder();
        if(n==1){
            res = new StringBuilder("1");
        }else{
            String raw=countAndSay(n-1);
            //init
            int i=0,j=1;
            while(j<raw.length()){
                if(raw.charAt(j-1)!=raw.charAt(j)){
                    int end=j-1;
                    res.append(desc(raw.charAt(end), i, end));
                    i=j;
                }
                j++;
            }
            res.append(desc(raw.charAt(j - 1), i, j - 1));
        }
        return res.toString();
    }

    private String desc(char a,int start,int end){
        return Integer.toString(end-start+1)+a;
    }
}
