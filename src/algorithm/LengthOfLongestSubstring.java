package algorithm;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.print(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] carray=s.toCharArray();
        int p1=0;int p2=0;
        int record=0;int maxinum=0;
        Set<Character> cset=new HashSet<>();
        while(p2 < s.length()){
            if(!cset.contains(carray[p2])){
                cset.add(carray[p2]);
                record++;
                if(maxinum < record){
                    maxinum=record;
                }
            } else {
                record++;
                while(p1 < p2){
                    if(carray[p1]!=carray[p2]){
                        cset.remove(carray[p1]);
                        p1++;
                        record--;
                    } else {
                        p1++;
                        record--;
                        break;
                    }

                }
            }
            p2++;
        }
        return maxinum;
    }
}
