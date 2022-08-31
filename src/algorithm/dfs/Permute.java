package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[]{1,2,3});
        int i = 1;
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> tmp = new ArrayList<>(nums.length);
        boolean[] selected = new boolean[nums.length];
        dfs(tmp, selected, nums);
        return res;
    }

    private static void dfs(List<Integer> tmp, boolean[] selected, int[] nums) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList(tmp));
            return;
        }

        for (int i = 0;i < nums.length;i++) {
            if (selected[i]) {
                continue;
            }
            selected[i] = true;
            tmp.add(nums[i]);
            dfs(tmp, selected, nums);
            selected[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
