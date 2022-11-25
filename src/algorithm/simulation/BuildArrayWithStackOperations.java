package algorithm.simulation;


import java.util.ArrayList;
import java.util.List;

// url:https://leetcode.cn/problems/build-an-array-with-stack-operations/submissions/
public class BuildArrayWithStackOperations {

    public List<String> buildArray(int[] target, int n) {
        List<String> res=new ArrayList<>();
        int pre=0;
        for(int e:target){
            for(int i=0;i<e-pre-1;i++){
                res.add("Push");res.add("Pop");
            }
            res.add("Push");
            pre=e;
        }
        return res;
    }
}
