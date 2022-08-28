package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BST_DLR_SearchAndFindTheLeaves {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();

        for(String c:s) {
            int x = Integer.parseInt(c);
            list.add(x);
        }

        shit(0,list.size()-1,list);
    }

    public static void shit(int start, int end, List<Integer> list) {
        if(start>end) return;
        else if(start == end) {
            System.out.print(list.get(start) + " ");
            return;
        } else { // start < end
            int idx = findidx(start+1,end,list,list.get(start)); //返回的值将是以当前节点为根节点的右子树的根节点
            if(idx <= end){
                shit(start+1,idx-1,list);
                shit(idx,end,list);
            }else{
                shit(start+1,idx-1,list);
            }
        }
    }

    public static int findidx(int start,int end,List<Integer> list,int target) {
        int i;
        for(i = start;i <= end;i++) {
            if(list.get(i) > target) return i;
        }
        return i;
    }
}
