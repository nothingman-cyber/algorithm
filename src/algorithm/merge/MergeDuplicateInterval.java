package algorithm.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeDuplicateInterval {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,4},{2,3}};
        MergeDuplicateInterval i = new MergeDuplicateInterval();
        int[][] res = i.merge(a);
        int dd=1;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        List<List<Integer>> res = new ArrayList<>();
        int start=intervals[0][0],end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(end>=intervals[i][0]){
                if(end<intervals[i][1]){
                    end=intervals[i][1];
                }
            }else{
                List<Integer> particalRes = new ArrayList<>();
                particalRes.add(start);
                particalRes.add(end);
                res.add(particalRes);
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }

        int[][] resArray=new int[res.size()+1][2];
        for(int i=0;i<res.size();i++){
            resArray[i][0]=res.get(i).get(0);
            resArray[i][1]=res.get(i).get(1);
        }
        resArray[res.size()][0]=start;
        resArray[res.size()][1]=end;
        return resArray;
    }
}
