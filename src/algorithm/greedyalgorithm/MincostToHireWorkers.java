package algorithm.greedyalgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MincostToHireWorkers {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n=quality.length;
        Integer[] h=new Integer[n];
        for(int i=0;i<h.length;i++){
            h[i]=i;
        }
        Arrays.sort(h,(a,b)-> wage[a]*quality[b]-wage[b]*quality[a]);
        double res=1e9;
        double totalq=0.0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<k-1;i++){
            totalq+=quality[h[i]];
            priorityQueue.offer(h[i]);
        }
        for(int i=k-1;i<n;i++){
            int idx=h[i];
            totalq+=quality[idx];
            priorityQueue.offer(quality[idx]);
            double totalc=((double)wage[idx]/quality[idx])*totalq;
            res=Math.min(res,totalc);
            totalq-=priorityQueue.poll();
        }
        return res;
    }
}
