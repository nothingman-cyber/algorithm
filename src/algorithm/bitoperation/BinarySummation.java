package algorithm.bitoperation;

// url:https://leetcode.cn/problems/add-binary/solution/
public class BinarySummation {

    // 不太对，有一半用例过不了
    public static void main(String[] args) {
        String a="1011";
        String b="1001";
        new BinarySummation().addBinary(a,b);
    }

    // todo 这段是十进制加法计算的位运算实现
    public String addBinary(String a, String b) {
        int x=q(a);
        int y=q(b);
        while(y!=0){
            int w=x^y;
            int e=(x&y)<<1;
            x=w;
            y=e;
        }
        return r(x);
    }

    private int q(String a){
        int i=0;
        for(int j=0;j<a.length();j++){
            i=i*2+(a.charAt(j)-'0');
        }
        return i;
    }

    private String r(int a){
        StringBuilder s=new StringBuilder();
        while(a>0){
            int t=a%2;
            s.append(t);
            a=a/2;
        }
        s.reverse();
        return s.toString();
    }
}
