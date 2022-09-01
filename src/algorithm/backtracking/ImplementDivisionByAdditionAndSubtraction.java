package algorithm.backtracking;


/**
 * https://leetcode.cn/problems/divide-two-integers/
 * Url : https://leetcode.cn/problems/divide-two-integers/solution/liang-shu-xiang-chu-by-leetcode-solution-5hic/
 */
public class ImplementDivisionByAdditionAndSubtraction {

    public static void main(String[] args) {
        int dividend = 12;
        int divisor = Integer.MIN_VALUE;

        System.out.println(dividend / divisor);

    }

    static int MAX = Integer.MAX_VALUE;
    static int MIN = Integer.MIN_VALUE;


    public int divide(int dividend, int divisor) {
        // 前提是除数不为0
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (MIN < dividend) {
                return -dividend;
            }
            return MAX;
        }
        long a = dividend;
        long b = divisor;
        int sign = 1;
        if ((a>0 && b<0) || (a<0 && b>0)) {
            sign = -1;
        }
        a = a>0?a:-a;
        b = b>0?b:-b;
        long res = div(a, b);
        if (sign == 1) {
            return (int)(MAX < res ? MAX : res);
        } else {
            return (int)-res;
        }
    }

    private long div(long a, long b) {
        if (a < b) return 0;
        long count = 1;
        long tb = b;
        while ((tb + tb) <= a) {
            count = count + count;
            tb = tb + tb;
        }
        return count + div(a - tb, b);
    }

}
