package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.print(networkDelayTime(times, 4, 2));
    }



    public static int networkDelayTime(int[][] times, int n, int k) {
        int[] table = new int[n+1];
        Set<Integer> nodeInLink = new HashSet<>(n);
        Set<Integer> nodeOutLink = new HashSet<>(n);

        // init
        for (int i=1;i<=n;i++) {
            table[i] = Integer.MAX_VALUE;
        }
        nodeInLink.add(k);
        for(int i=1;i<=n;i++){
            if(i!=k){
                nodeOutLink.add(i);
            }
        }
        table[k]=0; // 起点权重为0
        int anchor = k; // 设置当前扫描锚点
        // process
        while (true) {
            for (int[] edge : times) {
                if (edge[0] == anchor && nodeOutLink.contains(edge[1])) {
                    int dep = edge[1];
                    int time = edge[2];
                    if (table[dep] > table[anchor] + time) {
                        table[dep] = table[anchor] + time;
                    }
                }
            }
            int shortest=Integer.MAX_VALUE;
            int nextAnchor=-1;
            for(int node:nodeOutLink){
                if(table[node] < shortest){
                    shortest=table[node];
                    nextAnchor=node;
                }
            }
            if(shortest==Integer.MAX_VALUE){
                return -1;
            }
            // 取当前最短权重的所在点进行下一轮
            nodeInLink.add(nextAnchor);
            nodeOutLink.remove(nextAnchor);
            if(nodeOutLink.size()==0){
                break;
            }
            anchor=nextAnchor;
        }

        int maxTimeTotal=-1;
        for(int i=1;i<=n;i++){
            if(table[i] > maxTimeTotal){
                maxTimeTotal=table[i];
            }
        }
        return maxTimeTotal;
    }
}
