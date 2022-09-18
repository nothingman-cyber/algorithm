package algorithm.graphicscomputing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// url:https://leetcode.cn/problems/making-a-large-island/
public class LargestArtificialIsland {

    public static void main(String[] args) {
        int[][] gz=new int[][]{{1,1,1},{1,1,1},{1,1,0}};
        int z=new LargestArtificialIsland().largestIsland(gz);
        int j=1;
    }

    boolean[][] visited;// 遍历边界水域的时候用
    int[][] g;

    public int largestIsland(int[][] grid) {
        g=grid;
        int n=g.length;
        int m=g[0].length;
        visited=new boolean[n][m];

        // 统计一遍图里各岛屿的大小情况
        Map<Integer,Integer> status=new HashMap<>();
        int no=2;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(g[i][j]==1){
                    int zero=doStats(i,j,no);
                    status.put(no,zero);
                    no++;
                }
            }
        }

        if(status.size()==0){
            return 1;
        }

        int res=0;
        boolean full=true;
        // 将边界水域遍历计算最大值
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(g[i][j]==-1){
                    res=Math.max(res,doCalc(i,j,status));
                    full=false;
                }
            }
        }
        if(full){
            return status.get(2);
        }
        return res;
    }

    Set<Integer> noSet=new HashSet<>();

    private int doCalc(int i,int j,Map<Integer,Integer> status){
        int res=0;
        int[] nos=new int[4];
        nos[0]=doCount(i + 1, j, status);
        nos[1]=doCount(i - 1, j, status);
        nos[2]=doCount(i, j + 1, status);
        nos[3]=doCount(i, j - 1, status);
        for(int no:nos){
            if(no!=0){
                noSet.add(no);
            }
        }
        for(Integer no:noSet) {
            res += status.get(no);
        }
        noSet.clear();
        return res+1;
    }

    private int doCount(int i,int j,Map<Integer,Integer> status){
        if(0<=i&&i<g.length&&0<=j&&j<g[0].length){
            if(status.containsKey(g[i][j])){
                return g[i][j];
            }
        }
        return 0;
    }

    private int doStats(int i,int j,int no){
        if(0<=i&&i<g.length&&0<=j&&j<g[0].length){
            if(g[i][j]==1) {
                g[i][j]=no;
                int a=doStats(i + 1, j, no);
                int b=doStats(i - 1, j, no);
                int c=doStats(i, j + 1, no);
                int d=doStats(i, j - 1, no);
                return a+b+c+d+1;
            }else if(g[i][j]==0){
                g[i][j]=-1;
            }
        }
        return 0;
    }

}


