package algorithm.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// url:https://leetcode.cn/problems/palindrome-partitioning/
public class PalindromePartitioning {

    List<List<String>> res=new ArrayList<>();
    Set<String> badRecord=new HashSet<>();
    List<String> tmp=new ArrayList<>();
    public List<List<String>> partition(String s) {
        doJob(s,0);
        return res;
    }

    private void doJob(String s,int start){
        if(start==s.length()){
            res.add(new ArrayList<>(tmp));
            return;
        }


        for(int i=start+1;i<=s.length();i++){
            String newo=s.substring(start,i);
            if(badRecord.contains(newo)){
                return;
            }else{
                if(isGood(newo)){
                    tmp.add(newo);
                    doJob(s,i);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }

    private boolean isGood(String s){
        int i=0,j=s.length()-1;
        while(i<=j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
