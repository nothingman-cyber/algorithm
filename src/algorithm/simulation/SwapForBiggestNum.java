package algorithm.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 严格来说这题不该分类到这里的
// url:https://leetcode.cn/problems/maximum-swap/submissions/
public class SwapForBiggestNum {


    public static void main(String[] args) {
        int res = new SwapForBiggestNum().maximumSwap(98368);
        int res1= 1;
    }

    public int maximumSwap(int num) {
        if(num<10){
            return num;
        }
        int numIfNoChange=num;
        List<Integer> numS=new ArrayList<>();
        while(num!=0){
            int rest=num%10;
            numS.add(rest);
            num=num/10;
        }
        for(int i=numS.size()-1;i>=0;i--){
            int maxJ=i;
            for(int j=i-1;j>=0;j--){
                if(numS.get(maxJ)<=numS.get(j)){
                    maxJ=j;
                }
            }
            if(i!=maxJ&&numS.get(i)!=numS.get(maxJ)){
                Collections.swap(numS, i, maxJ);

                int res=0;
                for(int z=numS.size()-1;z>=0;z--){
                    res=res*10+numS.get(z);
                }
                return res;
            }
        }
        return numIfNoChange;
    }
}
