package net1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int val;
    Node next;
}

public class FirstQues {
    // 数组+链表
    static Node[] map;
    static int hang;
    static int lie;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] total = br.readLine().split(" ");
        // 4 4 1
        hang = Integer.parseInt(total[0]); // 行
        lie = Integer.parseInt(total[1]); // 列
        int time = Integer.parseInt(total[2]); // 操作次数
        initMap(br);
        for(int i=0;i<time;i++) {
            sortOperation(br);
        }
        printMap();
    }

    public static void initMap(BufferedReader br) throws IOException{
        map = new Node[hang];
        for(int i=0;i<hang;i++) {
            map[i] = new Node();
            map[i].val = -1; // 以-1作为开头
        }
        for(int i=0;i<hang;i++) {
            String[] strings = br.readLine().split(" ");
            map[i].next = new Node();
            Node now = map[i].next;
            now.val = Integer.parseInt(strings[0]);
            for(int j=1;j<lie;j++) {
                Node node = new Node();
                node.val = Integer.parseInt(strings[j]);
                now.next = node;
                now = node;
            }
            Node wei = new Node();
            wei.val = -2; // 以-2作为结尾
            now.next = wei;
        }
    }

    public static void sortOperation(BufferedReader br) throws IOException{
        String[] strings = br.readLine().split(" ");
        int[] hangRange = new int[2];
        int[] lieRange = new int[2];
        int orderWant = 0;
        int asc = 1;

        hangRange[0] = Integer.parseInt(strings[0]); // 2行
        hangRange[1] = Integer.parseInt(strings[1]); // 3行
        lieRange[0] = Integer.parseInt(strings[2]); // 2列
        lieRange[1] = Integer.parseInt(strings[3]); // 3列
        orderWant = Integer.parseInt(strings[4]); // 指定3是目标列
        asc = Integer.parseInt(strings[5]); // 0是升序，1是降序

        // 目标区块前的一列
        Node[] headBefore = new Node[hangRange[1]-hangRange[0]+1]; // 有2个元素
        // 目标区块中的最后一列
        Node[] headLast = new Node[hangRange[1]-hangRange[0]+1]; // 有2个元素
        // 目标索引列
        Node[] wantLie = new Node[hangRange[1]-hangRange[0]+1]; // 有2个元素

        // 初始化工具列
        InitToolArrays(hangRange[0],hangRange[1],lieRange[0],lieRange[1],orderWant,headBefore,headLast,wantLie);

        // 执行交换
        compareAndSwap(headBefore, headLast, wantLie, asc);
    }

    // 初始化3个工具列，且l1<=o<=l2
    public static void InitToolArrays(int h1, int h2, int l1, int l2, int o, Node[] headBefore, Node[] headLast, Node[] wantLie) {
        for(int i=h1-1;i<=h2-1;i++) {
            Node tmp = map[i];
            // 找到区块前一列的元素
            for (int j = 0; j < l1 - 1; j++) {
                tmp = tmp.next;
            }
            headBefore[i - (h1 - 1)] = tmp;
            // 继续，找到区块内要求遵循排序的那一列
            for(int j=0;j<=o-l1;j++) {
                tmp = tmp.next;
            }
            wantLie[i-(h1-1)] = tmp;
            // 继续，找到区块内最后一列的元素
            for (int j = 0; j < l2 - o; j++) {
                tmp = tmp.next;
            }
            headLast[i - (h1 - 1)] = tmp;
        }
    }

    // 冒泡：0是升序，1是降序
    public static void compareAndSwap(Node[] before, Node[] last, Node[] order, int asc) {
        int len = order.length;
        for(int i=0;i<len-1;i++) {
            for(int j=0;j<len-(i+1);j++) {
                boolean isCompare = compare(order, j, j+1, asc);
                if(isCompare) {
                    swap(before,last,order,j,j+1);
                }
            }
        }
    }

    // 升序和降序综合起来：不管怎么说，我们只希望知道交换会不会发生。所以true是应该交换，而false是不应该交换
    public static boolean compare(Node[] map,int i,int j,int asc) {
        if(asc == 0) { // 升序
            if(map[i].val > map[j].val) {
                return true;
            } else {
                return false;
            }
        }
        if(asc == 1) {
            if(map[i].val < map[j].val) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    // 交换的具体操作
    public static void swap(Node[] before, Node[] last, Node[] order, int i, int j) {
        // 先交换索引列
        Node tmp = order[i];
        order[i] = order[j];
        order[j] = tmp;
        // 区块前列中的元素不交换，但交换其next元素指针
        tmp = before[i].next;
        before[i].next = before[j].next;
        before[j].next = tmp;
        // 区块中最后一列的元素交换，并交换其next元素指针
        tmp = last[i];
        last[i] = last[j];
        last[j] = tmp;
        tmp = last[i].next;
        last[i].next = last[j].next;
        last[j].next = tmp;
    }

    // 打印
    public static void printMap() {
        for(Node a:map) {
            Node now = a.next;
            while(now.val != -1 && now.val != -2) {
                System.out.print(now.val);
                if(now.next.val != -2) {
                    System.out.print(" ");
                }
                now = now.next;
            }
            System.out.println();
        }
    }
}
