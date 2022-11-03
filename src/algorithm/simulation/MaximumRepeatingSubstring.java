package algorithm.simulation;

// url:https://leetcode.cn/problems/maximum-repeating-substring/submissions/
public class MaximumRepeatingSubstring {

    public int maxRepeating(String sequence, String word) {
        String a=word;
        int res=0;
        while(sequence.contains(a)){
            a=a+word;
            res++;
        }
        return res;
    }
}
