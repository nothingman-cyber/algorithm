package algorithm.sort;

// url:https://leetcode.cn/problems/merge-sorted-array/
// the solution is wrong.
public class CombineWithSort {

    public static void main(String[] args) {


        int[] nums1 = {0};
        int[] nums2 = {2};
        new CombineWithSort().merge(nums1,0,nums2,1);
        int i=2;
    }


    public void merge(int[] n1, int m, int[] n2, int n) {
        int i=m+n;
        m--;
        n--;
        while(n>=0){
            while(m>=0&&n1[m]>n2[n]){
                int t=n1[m];
                n1[m]=n2[n];
                n2[n]=t;
                i--;
                m--;
            }
            int t=n1[i];
            n1[i]=n2[n];
            n2[n]=t;
            i--;
            n--;
        }
    }
}
