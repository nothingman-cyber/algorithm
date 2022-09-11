package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

public class CnmCombine {

    public static void main(String[] args) {
        CnmCombine cnmCombine = new CnmCombine();
        cnmCombine.combine(4,2);
    }

    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> tmp=new ArrayList<>(k);
        for(int i=1;i<=n-k+1;i++){
            tmp.add(i);
            if(k==1){
                res.add(new ArrayList<>(tmp));
            }else{
                dfs(i+1,n,k-1,tmp);
            }
            tmp.remove(tmp.size()-1);
        }
        return res;
    }

    private void dfs(int start,int end,int k, List<Integer> tmp){
        if(k==1){
            for(int i=start;i<=end;i++){
                tmp.add(i);
                res.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size()-1);
            }
        }else{
            for(int i=start;i<=end;i++){
                tmp.add(i);
                dfs(i+1,end,k-1,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
