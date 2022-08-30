package algorithm;

/**
 * Url : https://leetcode.cn/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/
 */
public class NextPermutation {

    // 从后往前找，对于第一个能 n[i] < n[i + 1] 的 n[i]，则取之
    // 对于 n[i], 必有 n[i + 1, end] 为下降序列，且存在一个值
    // n[j]，它是大于n[i]的，但又能做到n[j + 1]小于n[i]，要么n[j]是吊车尾
    // 交换 n[i] 和 n[j]
    // 再把n[i+1, end] 变为上升队列

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int idx = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            // 要么到头了，要么找到了，反正总有一个能实现
            // 不管是哪个，照着步骤走都能实现结果，因为如果是最后一个序列，可以拿头一个序列
            if (i == 0 || nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }
        // [idx + 1, end]
        int jdx = 0; // 哨兵值
        for (int i = nums.length - 1; i >= idx - 1; i--) {
            if (i == 0 || nums[i] > nums[idx]) {
                jdx = i;
                break;
            }
        }

        swap(nums, idx, jdx);

        reverse(nums, idx + 1);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start ++;
            end --;
        }
    }
}
