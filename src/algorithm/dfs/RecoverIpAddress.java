package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

// url:https://leetcode.cn/problems/restore-ip-addresses/solution/fu-yuan-ipdi-zhi-by-leetcode-solution/
public class RecoverIpAddress {

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = new RecoverIpAddress().restoreIpAddresses(s);
        int i=1;
    }

    List<List<String>> res;
    List<String> finalRes;



    public List<String> restoreIpAddresses(String s) {
        res=new ArrayList<>();
        finalRes=new ArrayList<>();
        if(s.length()<4||s.length()>12){
            return new ArrayList<>();
        }
        char[] cs=s.toCharArray();
        List<String> ip=new ArrayList<>(4);
        dfs(ip,cs,0,1);
        return genRes();
    }

    private void dfs(List<String> ip, char[] ipString, int idx, int segment){
        int restMinSpace=4-segment;//给后面留下来的最小空间
        int idxSide=ipString.length-restMinSpace;//根据最小空间，当前段落所能触及的边界下标
        if(segment<4){
            for(int i=idx;i<=idxSide;i++){
                if(idxSide-i<3){
                    int segIp=valid(ipString,idx,i);
                    if(segIp!=-1){
                        ip.add(Integer.toString(segIp));
                        dfs(ip,ipString,i+1,segment+1);
                        ip.remove(ip.size()-1);
                    }
                }
            }
        }else if(segment==4){
            for(int i=idx;i<=idxSide;i++){
                if(idxSide-i<3){
                    int segIp=valid(ipString,idx,i);
                    if(segIp!=-1){
                        ip.add(Integer.toString(segIp));
                        res.add(new ArrayList<>(ip));
                        ip.remove(ip.size()-1);
                    }
                }
            }
        }
    }

    private int valid(char[] ipString, int start, int end){
        if(ipString[start]=='0'){
            if(end==start){
                return 0;
            }else{
                return -1;
            }
        }else{
            int segment=0;
            for(int i=start;i<=end;i++){
                segment=segment*10+(ipString[i]-'0');
            }
            if(0<segment&&segment<=255){
                return segment;
            }else{
                return -1;
            }
        }
    }

    public List<String> genRes(){
        if(res.size()==0){
            return new ArrayList<>();
        }else{
            for(List<String> ip:res){
                String finalIp="";
                for(int i=0;i<4;i++){
                    finalIp=finalIp+ip.get(i);
                    if(i<3){
                        finalIp=finalIp+".";
                    }
                }
                finalRes.add(finalIp);
            }
            return finalRes;
        }
    }
}
