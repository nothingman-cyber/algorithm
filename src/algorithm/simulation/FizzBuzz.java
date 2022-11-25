package algorithm.simulation;

import java.util.ArrayList;
import java.util.List;

// url:https://leetcode.cn/problems/fizz-buzz/
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        String[] res=new String[n];
        for(int i=0;i<n;i++){
            int ii=i+1;
            if(ii%3==0&&ii%5==0){res[i]="FizzBuzz";continue;}
            if(ii%3==0){res[i]="Fizz";continue;}
            if(ii%5==0){res[i]="Buzz";continue;}
            res[i]=String.valueOf(ii);
        }
        List<String> finalRes=new ArrayList<>(n);
        for(String s:res){
            finalRes.add(s);
        }
        return finalRes;
    }
}
