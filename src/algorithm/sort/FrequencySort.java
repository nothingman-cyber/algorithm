package algorithm.sort;

import java.util.*;

//url:https://leetcode.cn/problems/sort-array-by-increasing-frequency/submissions/
public class FrequencySort {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i:nums){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                int p=map.get(i);
                map.put(i,p+1);
            }
        }
        List<Integer> l=new ArrayList<>();
        for(int i:nums){
            l.add(i);
        }
        Collections.sort(l,(a, b) -> {
            int av = map.get(a);
            int bv = map.get(b);
            return av != bv ? av - bv : b - a;
        });//定义排序谓词直接一步完成操作
        for(int i=0;i<nums.length;i++){
            nums[i]=l.get(i);
        }
        return nums;
    }
}
