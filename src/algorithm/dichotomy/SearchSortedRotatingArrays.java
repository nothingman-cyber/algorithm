package algorithm.dichotomy;

// url:https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/
public class SearchSortedRotatingArrays {

    public boolean search(int[] nums, int target) {
        int n=nums.length;
        if(n==0){
            return false;
        }
        if(n==1){
            return nums[0]==target;
        }
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[low]==nums[mid]&&nums[mid]==nums[high]){
                low++;
                high--;
            }else if(nums[low]<=nums[mid]){
                if(nums[low]<=target&&target<nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(nums[mid]<target&&target<=nums[n-1]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return false;
    }
}
