package algorithm.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

// url:https://leetcode.cn/problems/sum-of-subarray-minimums/
public class SumOfTheMinimumValueOfAllSubarrays {

    public static void main(String[] args) {
        int[] met=new int[]{3,1,2,4,1};
        SumOfTheMinimumValueOfAllSubarrays s=new SumOfTheMinimumValueOfAllSubarrays();
        s.sumSubarrayMins(met);
    }

    public int sumSubarrayMins(int[] arr){
        int MOD=1000000007;
        int[] left=calculateLeftMinimums(arr);
        int[] right=calculateRightMinimums(arr);
        long ans=0;
        for(int i=0;i<arr.length;i++){
            ans=(ans+(long)(i-left[i])*(right[i]-i)*arr[i])%MOD;
        }
        return (int)ans;
    }


    private int[] calculateLeftMinimums(int[] arr){
        int len=arr.length;
        int[] leftMinimum=new int[len];
        Deque<Integer> deque=new ArrayDeque<>(len);
        for(int i=0;i<len;i++){
            while(!deque.isEmpty()&&arr[deque.peek()]>arr[i]){
                deque.pop();
            }
            if(deque.isEmpty()){
                leftMinimum[i]=-1;
            }else{
                leftMinimum[i]=deque.peek();
            }
            deque.push(i);
        }
        return leftMinimum;
    }

    private int[] calculateRightMinimums(int[] arr){
        int len=arr.length;
        int[] rightMinimum=new int[len];
        Deque<Integer> deque=new ArrayDeque<>(len);
        for(int i=len-1;i>=0;i--){
            while(!deque.isEmpty()&&arr[deque.peek()]>=arr[i]){
                deque.pop();
            }
            if(deque.isEmpty()){
                rightMinimum[i]=-1;
            }else{
                rightMinimum[i]=deque.peek();
            }
            deque.push(i);
        }
        return rightMinimum;
    }
}
