package algorithm.simulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// url:https://leetcode.cn/problems/intersection-of-two-arrays
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1=new HashSet();
        Set<Integer> s2=new HashSet();

        for(int n1:nums1){
            s1.add(n1);
        }
        for(int n2:nums2){
            s2.add(n2);
        }


        List<Integer> sl=new ArrayList<>();
        s1.stream().forEach(num->{
           if(s2.contains(num)){
               sl.add(num);
           }
        });
        int[] res=new int[sl.size()];
        for(int i=0;i<sl.size();i++){
            res[i]=sl.get(i);
        }
        return res;
    }
}
