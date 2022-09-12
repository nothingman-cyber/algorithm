package algorithm.bitoperation;

import java.util.ArrayList;
import java.util.List;

// url:https://leetcode.cn/problems/gray-code/
public class GrayCoding {

    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            ret.add((i >> 1) ^ i);
        }
        return ret;
    }
}
