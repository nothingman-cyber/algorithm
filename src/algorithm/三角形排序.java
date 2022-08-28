package algorithm;

import java.util.ArrayList;

class Tri {
    int[] top = new int[3];
    boolean dirt;

    public Tri(int a,int b,int c) {
        top[0] = a;
        top[1] = b;
        top[2] = c;
        this.dirt = true;
    }
}

public class 三角形排序 {
    public static void main(String[] args) {

    }

    public static boolean isCloset(Tri a, Tri b) {
        ArrayList<Integer> ll = new ArrayList<>();
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(a.top[i]==b.top[j]) {
                    ll.add(i);
                    ll.add(j);
                }
            }
        }
        if(ll.size()==4) {
            int a1 = ll.get(0);
            int a2 = ll.get(2);
            int b1 = ll.get(1);
            int b2 = ll.get(3);
            int c1 = (a1-b1<0)?a1-b1+3:a1-b1;
            int c2 = (a2-b2<0)?a2-b2+3:a2-b2;
            if(c1==c2) {
                b.dirt = a.dirt;
            } else {
                b.dirt = !a.dirt;
            }

        } else {

        }
        return false;
    }
}
