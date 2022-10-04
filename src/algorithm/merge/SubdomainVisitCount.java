package algorithm.merge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {

    public static void main(String[] args) {
        String[] cpdomains = {"9001 com","1 www.com"};
        List<String> r=new SubdomainVisitCount().subdomainVisits(cpdomains);
        int i=1;
    }

    Map<String,Integer> res=new HashMap<>();
    public List<String> subdomainVisits(String[] cpdomains) {
        for(String cp:cpdomains){
            String[] cps=cp.split(" ");
            int ddSum=Integer.parseInt(cps[0]);
            List<String> dd=doSplit(cps[1]);
            for(String d:dd){
                if(res.containsKey(d)){
                    res.put(d,res.get(d)+ddSum);
                }else{
                    res.put(d,ddSum);
                }
            }
        }
        List<String> finalRes=new ArrayList<>();
        for(Map.Entry<String,Integer> en:res.entrySet()){
            finalRes.add(en.getValue()+" "+en.getKey());
        }
        return finalRes;
    }

    private List<String> doSplit(String domain){
        String[] dos=domain.split("\\.");
        List<String> dd=new ArrayList<>(dos.length);
        for(int i=0;i<dos.length;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<dos.length;j++){
                sb.append(dos[j]);
                if(j<dos.length-1){
                    sb.append(".");
                }
            }
            dd.add(sb.toString());
        }
        return dd;
    }
}
