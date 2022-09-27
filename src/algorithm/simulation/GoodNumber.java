package algorithm.simulation;

// url:https://leetcode.cn/problems/rotated-digits/submissions/
public class GoodNumber {

    public static void main(String[] args) {
        int j=new GoodNumber().rotatedDigits(12);
        int i=1;
    }

    public int rotatedDigits(int n) {
        int res=0;
        for(int i=1;i<=n;i++){
            if(good(i)){
                res++;
            }
        }
        return res;
    }

    public boolean good(int a){
        int q=a;
        int c=0;
        int location=0;
        while(q!=0){
            int r=q%10;
            int z=getRotate(r);
            if(z==-1){
                return false;
            }
            c+=z*Math.pow(10,location++);
            q=q/10;
        }
        if(c==a){
            return false;
        }
        return true;
    }

    public int getRotate(int a){
        if(a==0||a==1||a==8){
            return a;
        }
        if(a==2||a==5){
            return a==2?5:2;
        }
        if(a==6||a==9){
            return a==6?9:6;
        }
        return -1;
    }
}
