package algorithm.simulation;

import java.util.*;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> m1=new HashMap<>();
        Map<Integer,Integer> m2=new HashMap<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int n1:nums1){
            if(m1.containsKey(n1)){
                int m1n1=m1.get(n1);
                m1n1++;
                m1.put(n1,m1n1);
            }else{
                m1.put(n1,1);
            }
        }
        for(int n2:nums2){
            if(m2.containsKey(n2)){
                int m2n2=m2.get(n2);
                m2n2++;
                m2.put(n2,m2n2);
            }else{
                m2.put(n2,1);
            }
        }


        List<Integer> sl=new ArrayList<>();

        for(Map.Entry<Integer,Integer> en:m1.entrySet()){
            if(m2.containsKey(en.getKey())){
                int o=Math.min(en.getValue(),m2.get(en.getKey()));
                for(int oi=0;oi<o;oi++){
                    sl.add(en.getKey());
                }
            }
        }

        int[] res=new int[sl.size()];
        for(int i=0;i<sl.size();i++){
            res[i]=sl.get(i);
        }
        return res;
    }
}
