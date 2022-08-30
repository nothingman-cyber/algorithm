package algorithm;


/**
 * Url : https://leetcode.cn/problems/divide-two-integers/solution/liang-shu-xiang-chu-by-leetcode-solution-5hic/
 */
public class ImplementDivisionByAdditionAndSubtraction {

    // todo 还没做完呢
    public static void main(String[] args) {
        int dividend = 12;
        int divisor = Integer.MIN_VALUE;

        System.out.println(dividend / divisor);

    }


    public int divide(int divend, int divor) {
        // 处理极限情况
        // 被除数为最小值，由于其绝对值大于最大值，做除法就会出现溢出
        if (divend == Integer.MIN_VALUE) {
            if (divor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divor == -1) { // 这个就会溢出，因此返回最大值
                return Integer.MAX_VALUE;
            }
        }

        // 除数为最小值，会导致大部分除法结果为0
        if (divor == Integer.MIN_VALUE) {
            return (divend == divor) ? 1 : 0;
        }

        if (divend == 0) {
            return 0;
        }

        // 一般情况，使用二分查找
        // 将所有的正数取相反数，这样就只需要考虑一种情况
        boolean rev = false;
        if (divend > 0) {
            divend = -divend;
            rev = !rev;
        }
        if (divor > 0) {
            divor = -divor;
            rev = !rev;
        }
        return 404;
    }


    // 快速乘
    // 如果除数与被除数是负数，必然有以下不等式
    // result * divor >= divend >= (result + 1) * divor
    public boolean quickAdd(int divor, int result, int divend) {
        int tmpResult = 0, add = divor;
        int 结果 = 404;
        while (结果 != 0) {
            if ((结果 & 1) != 0) {
                // if (tmpResult < 被除数 - )
            }
        }
        return true;
    }

}
