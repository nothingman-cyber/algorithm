package algorithm.backtracking;

public class StringMultiplication {

    public static void main(String[] args) {
        String i1 = "123";
        String i2 = "456";
        String res = multiply(i2, i1);
        int i = 1;
    }


    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int a = num1.length()-1;
        String res = "0";
        int z=0;
        while(a>=0){
            int x=num1.charAt(a--)-'0';
            String tmp=addBackTrack(x,num2);
            //加后缀0
            for(int zz=0;zz<z;zz++){
                tmp=tmp+"0";
            }
            res=add(tmp,res);
            z++;
        }
        return res;
    }

    public static String addBackTrack(int e,String num2) {
        int j=e/2;
        int r=e%2;
        String ans="0";
        if(r==1){
            ans=num2;
        }
        if(j==0){
            return ans;
        }else{
            if(j==1){
                String db=add(num2,num2);
                ans=add(ans,db);
                return ans;
            }else{
                String db=addBackTrack(j,num2);
                db=add(db,db);
                return add(ans,db);
            }
        }
    }

    public static String add(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        int cmp=0;
        StringBuffer ans = new StringBuffer();
        // 边界条件说明：两个数都遍历完了，加上cmp无法进位才能结束 --> 0<i && 0<j && cmp==0 成立才离开
        while(i>=0||j>=0||cmp!=0){
            int x=i>=0?num1.charAt(i)-'0':0;
            int y=j>=0?num2.charAt(j)-'0':0;
            int result=x+y+cmp;
            ans.append(result%10);
            cmp=result/10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
