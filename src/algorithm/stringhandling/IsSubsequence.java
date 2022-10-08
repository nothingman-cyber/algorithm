package algorithm.stringhandling;

// url:https://leetcode.cn/problems/is-subsequence/submissions/
public class IsSubsequence {

    public static void main(String[] args) {
        String s="aaaaaa";
        String t="bbaaaa";
        new IsSubsequence().isSubsequence(s,t);
        int i=1;
    }

    public boolean isSubsequence(String s, String t) {
        if(t.length()<s.length()){return false;}
        int si=0,ti=0;
        while(si<s.length()){
            char ss=s.charAt(si);
            while(ti<t.length()&&t.charAt(ti)!=ss){ti++;};
            if(ti==t.length()){return false;}
            si++;
            ti++;
        }
        if(si==s.length()){return true;}
        return false;
    }
}
