package algorithm.stringhandling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// url:https://leetcode.cn/problems/group-anagrams/solution/
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea"};
        GroupAnagrams anagrams = new GroupAnagrams();
        List<List<String>> b = anagrams.groupAnagrams(strs);
        int i=1;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
        Map<String,List<String>> res = new HashMap<>();
        for(String str:strs){
            String orderString=count(str);
            if(res.containsKey(orderString)){
                res.get(orderString).add(str);
            }else{
                List<String> l=new ArrayList<>();
                l.add(str);
                res.put(orderString,l);
            }
        }
        for(Map.Entry<String,List<String>> en:res.entrySet()){
            ans.add(en.getValue());
        }
        return ans;
    }

    private String count(String str) {
        int[] buckets = new int[26];
        for(int i=0;i<str.length();i++) {
            int bucket=str.charAt(i)-'a';
            buckets[bucket]++;
        }
        StringBuilder res= new StringBuilder();
        for(int i=0;i<26;i++){
            if(buckets[i]!=0){
                res.append(buckets[i]).append((char)(i + 'a'));
            }
        }
        return res.toString();
    }
}
