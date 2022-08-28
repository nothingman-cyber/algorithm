package algorithm;

public class SwapThe0 {
    public static void main(String[] args) {
        int[] a = {0,1,0,2,0,3,0,4,5};
        specificOperation(a);
        for(int i:a) {
            System.out.print(i+" ");
        }
    }

    public static void specificOperation(int[] a) {
        int last0 = -1;
        for(int i=0;i<a.length;i++) {
           if(a[i]!=0&&i>0) { // 1
               if(a[i-1]==0 && last0==-1) {
                   swap(a, i, i-1);
                   last0 = i;
               } else {
                   swap(a, i, last0);
                   last0++;
               }
           }
        }
    }

    public static void swap(int[] i,int a,int b) {
        i[a] = i[a]+i[b];
        i[b] = i[a]-i[b];
        i[a] = i[a]-i[b];
    }
}
