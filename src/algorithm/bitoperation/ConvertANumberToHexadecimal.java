package algorithm.bitoperation;

// url:https://leetcode.cn/problems/convert-a-number-to-hexadecimal
public class ConvertANumberToHexadecimal {

    public String toHex(int num) {
        if(num==0)return "0";
        StringBuilder sb=new StringBuilder();
        while(num!=0){
            int u=num&15;
            char c=(char)(u+'0');
            if(u>=10)c=(char)(u-10+'a');
            sb.append(c);
            num>>>=4;
        }
        return sb.reverse().toString();
    }
}
