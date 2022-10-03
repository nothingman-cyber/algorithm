package algorithm.bitoperation;

// url:https://leetcode.cn/problems/counting-bits/
public class BitCount {

    public int[] countBits2(int n) {
        int[] s=new int[n+1];
        s[0]=0;
        for(int i=1;i<=n;i++){
            if(i%2==1){
                s[i]=s[i-1]+1;
            }else{
                s[i]=s[i/2];
            }
        }
        return s;
    }

    public int[] countBits(int n) {
        int[] s=new int[n+1];
        int highBit=0;
        for(int i=1;i<=n;i++){
            if((i&(i-1))==0){
                highBit=i;
            }
            s[i]=s[i-highBit]+1;
        }
        return s;
    }
}
