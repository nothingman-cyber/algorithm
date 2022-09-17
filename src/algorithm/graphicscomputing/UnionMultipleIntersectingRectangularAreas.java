package algorithm.graphicscomputing;

import java.util.*;

public class UnionMultipleIntersectingRectangularAreas {

    // rectangle={x1,y1,x2,y2}


    public int rectangleArea(int[][] rectangles) {
        final int MOD=1000000007;
        int n=rectangles.length;
        Set<Integer> set=new HashSet<Integer>();
        for(int[] rect:rectangles){
            set.add(rect[1]);
            set.add(rect[3]);
        }
        List<Integer> hbound=new ArrayList<Integer>(set);
        Collections.sort(hbound);
        int m=hbound.size();
        int[] seg=new int[m-1];
        List<int[]> sweep=new ArrayList<int[]>();
        for(int i=0;i<n;i++){
            sweep.add(new int[]{rectangles[i][0],i,1});
            sweep.add(new int[]{rectangles[i][2],i,-1});
        }
        Collections.sort(sweep,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }else if(a[1]!=b[1]){
                return a[1]-b[1];
            }else{
                return a[2]-b[2];
            }
        });
        long ans=0;
        for(int i=0;i<sweep.size();i++){
            int j=i;
            while(j+1<sweep.size()&&
            sweep.get(i)[0]==sweep.get(j+1)[0]){
                ++j;
            }
            if(j+1==sweep.size()){
                break;
            }
            for(int k=i;k<=j;k++){
                int[] arr=sweep.get(k);
                int idx=arr[1],diff=arr[2];
                int left=rectangles[idx][1],
                        right=rectangles[idx][3];
                for(int x=0;x<m-1;x++){
                    if(left<=hbound.get(x)&&hbound.get(x+1)<=right){
                        seg[x]+=diff;
                    }
                }
            }
            int cover=0;
            for(int k=0;k<m-1;k++){
                if(seg[k]>0){
                    cover+=(hbound.get(k+1)-hbound.get(k));
                }
            }
            ans+=(long)cover*(sweep.get(j+1)[0]-sweep.get(j)[0]);
            i=j;
        }
        return (int)(ans%MOD);
    }
}
