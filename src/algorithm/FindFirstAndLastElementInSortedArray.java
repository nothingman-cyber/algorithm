package algorithm;

public class FindFirstAndLastElementInSortedArray {

    public int[] solution(int[] nums, int target) {
        int l = 0, r = nums.length  - 1;
        int min = -1, max = -1;
        while(l <= r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] == target) {
                int lr = mid;
                min = mid;
                while (l <= lr) {
                    int lm = l + (lr - l >> 1);
                    if (nums[lm] == target) {
                        min = lm;
                        lr = lm - 1;
                    } else {
                        l = lm + 1;
                    }
                }
                int rl = mid;
                max = mid;
                while (rl <= r) {
                    int rm = rl + (r - rl >> 1);
                    if (nums[rm] == target) {
                        max = rm;
                        rl = rm + 1;
                    } else {
                        r = rm - 1;
                    }
                }
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[] {min, max};
    }

}
