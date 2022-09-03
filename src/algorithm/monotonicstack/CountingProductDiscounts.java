package algorithm.monotonicstack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/solution/by-ac_oier-hw5b/
public class CountingProductDiscounts {

    public int[] finalPrices(int[] ps) {
        int n = ps.length;
        int[] ans = new int[n];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0;i < n;i++) {
            // 从队列末尾取商品，如果这个商品价格比当前商品价格大，那么就可以开始打折了！
            while(!d.isEmpty() && ps[d.peekLast()]>=ps[i]){
                int idx = d.pollLast();
                ans[idx]=ps[idx]-ps[i];
            }
            d.addLast(i); // 把当前商品放进队列末尾
            ans[i]=ps[i];
        }
        return ans;
    }

    public int[] finalPrices2(int[] ps) {
        List<Integer> monoStack = new ArrayList<>(ps.length);
        int[] ans = new int[ps.length];
        for (int i = 0;i < ps.length;i++) {
            while (monoStack.size()!=0&&ps[i]<=ps[monoStack.get(monoStack.size()-1)]){
                int topElementPrice = ps[monoStack.get(monoStack.size()-1)];
                ans[monoStack.get(monoStack.size()-1)] = topElementPrice-ps[i];
                monoStack.remove(monoStack.size()-1);
            }

            monoStack.add(i);
            ans[i] = ps[i];
        }
        return ans;
    }
}
