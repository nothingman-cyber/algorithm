package net1;

class FON_Node{
    int val;
}

public class FindOddNumber {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,8,9,10,10,9,8,7,6,5,4,1,2,3,3,0};
        int[] b = {1,1,1,2,4,3,3};
        System.out.print(fintIt(a));
        Class clazz = FindOddNumber.class;
    }

    // 前提是只有一个数
    public static int fintIt(int[] a) {
        int xor = 0;
        for(int i=0;i<a.length;i++) {
            xor ^= a[i];
        }
        return xor;
    }

    public static int violence(int[] a) {
        // 先排序，然后再遍历一遍找出来
        return 404;
    }

    public static int buildIt(int[] a) {
        return 1;
    }
}
