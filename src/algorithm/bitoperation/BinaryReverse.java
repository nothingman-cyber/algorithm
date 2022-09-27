package algorithm.bitoperation;

// url:https://leetcode.cn/problems/reverse-bits/submissions/
public class BinaryReverse {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            res=(res<<1)|(n&1);
            n=n>>1;
        }
        return res;
    }
}
