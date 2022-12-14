package algorithm.bitoperation;

// url:https://leetcode.cn/problems/number-of-1-bits/
public class NumOfBit1 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            res+=n&1;
            n=n>>1;
        }
        return res;
    }
}
