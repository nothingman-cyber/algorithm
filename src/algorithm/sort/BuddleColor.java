package algorithm.sort;

// url:https://leetcode.cn/problems/sort-colors/submissions/
public class BuddleColor {

    public static void main(String[] args) {
        int[] n = new int[]{2,0,1};
        BuddleColor color = new BuddleColor();
        color.sortColors(n);
    }

    public void sortColors(int[] nums){
        bubbleColor(nums,2);
        bubbleColor(nums,1);
    }

    private void bubbleColor(int[] nums, int color){
        int j=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==color){
                while(nums[j]>=color){
                    j--;
                }
                if(nums[j]<color&&i<j){
                    int tmp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=tmp;
                }
            }
        }
    }
}
