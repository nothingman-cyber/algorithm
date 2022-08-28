package net1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Loc {
    int x;
    int y;
    Loc timeNext; // 时间关联
    Loc manNext; // 同一时刻其他玩家关联
    public Loc(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public Loc() {

    }
}

class Operation {
    int player;
    int time;
    int len;
    int dir; // W:1 A:2 S:3 D:4
}

public class SecondQues {

    static Loc[] players; // 玩家轨迹链数组
    static Operation[] actions; // 玩家行为数组
    static int map_X; // 地图X宽
    static int map_Y; // 地图Y宽

    // 本玩家视野范围
    // up
    // |
    // |
    // left&down_______right

    static int my_left;
    static int my_right;
    static int my_down;
    static int my_up;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initTotal(br);
        initPlayers(br);
        initActions(br);
        buildPlayers();
        query(br);
    }



    public static void initTotal(BufferedReader br) throws IOException {
        String[] strings = br.readLine().split(" ");
        map_X = Integer.parseInt(strings[0]);
        map_Y = Integer.parseInt(strings[1]);
        int my_X = Integer.parseInt(strings[2]);
        int my_Y = Integer.parseInt(strings[3]);
        int R = Integer.parseInt(strings[4]);
        my_left = (my_X-R<=0)?1:my_X-R;
        my_right = (my_X+R>map_X)?map_X:my_X+R;
        my_down = (my_Y-R<=0)?1:my_Y-R;
        my_up = (my_Y+R>map_Y)?map_Y:my_Y+R;

    }

    public static void query(BufferedReader br) throws IOException {
        int time = Integer.parseInt(br.readLine());
        String[] seconds = br.readLine().split(" ");
        for(int i=0;i<time;i++) {
            int sec = Integer.parseInt(seconds[i]);
            Loc start = players[0];
            for(int j=0;j<sec;j++) {
                start = start.timeNext;
            }
            int num = 0;
            while(start != null) {
                if(judge(start)) {
                    num++;
                }
                start = start.manNext;
            }
            System.out.print(num + " ");
        }
    }

    public static boolean judge(Loc s) {
        if(my_left<=s.x&&s.x<=my_right&&my_down<=s.y&&s.y<=my_up) {
            return true;
        }
        return false;
    }

    public static void initActions(BufferedReader br) throws IOException {
        int operations = Integer.parseInt(br.readLine());
        actions = new Operation[operations];
        for(int i=0;i<operations;i++) {
            String[] ss = br.readLine().split(" ");
            Operation op = new Operation();
            op.player = Integer.parseInt(ss[0]);
            op.time = Integer.parseInt(ss[1]);
            op.len = Integer.parseInt(ss[2]);
            if(ss[3].equals("W")) {
                op.dir = 1;
            }
            if(ss[3].equals("A")) {
                op.dir = 2;
            }
            if(ss[3].equals("S")) {
                op.dir = 3;
            }
            if(ss[3].equals("D")) {
                op.dir = 4;
            }
            actions[i] = op;
        }
    }

    public static void initPlayers(BufferedReader br) throws IOException{
        int num = Integer.parseInt(br.readLine());
        players = new Loc[num];
        for(int i=0;i<num;i++) {
            players[i] = new Loc();
            String[] loc = br.readLine().split(" ");
            players[i].x = Integer.parseInt(loc[0]);
            players[i].y = Integer.parseInt(loc[1]);
        }
    }

    // 根据最大时间值来创建位置链
    public static void buildPlayers() {
        int max = sortActionsByTime();
        int pls = players.length;
        int idx = 0; // actions 数组索引
        Loc[] tmpLoc = new Loc[pls];
        for(int i=0;i<=max;i++) {
            if(i==0) { // 取0秒的位置为前置内容，用于1秒的操作
                for(int ps = 0;ps < players.length;ps++) {
                    tmpLoc[ps] = players[ps];
                }
                continue;
            }
            Loc tmp = new Loc(); // 用来连接同1秒的位置
            for(int j=0;j<pls;j++) { // pls 是其他玩家数量，每秒遍历增加一遍
                if(idx < actions.length && actions[idx].time == i && actions[idx].player-1 == j) { // 操作定位
                    tmpLoc[j].timeNext = move(tmpLoc[j], actions[idx]);
                    idx++;
                } else {
                    tmpLoc[j].timeNext = new Loc(tmpLoc[j].x, tmpLoc[j].y);
                }
                tmpLoc[j] = tmpLoc[j].timeNext; // 当前秒位置成为下一秒操作的基准
                if(j==0) { // 从第1秒开始进行横向串联
                    tmp = tmpLoc[j];
                } else {
                    tmp.manNext = tmpLoc[j]; // 同一秒操作串联
                    tmp = tmp.manNext;
                }
            }
        }
    }

    // 按照地图规则移动
    public static Loc move(Loc l, Operation o) {
        int len = o.len;
        int dir = o.dir;
        Loc newOne = new Loc();
        if(dir==1) {
            newOne.x = l.x;
            newOne.y = (l.y+len>map_Y)?map_Y:l.y+len;
        }
        if(dir==2) {
            newOne.y = l.y;
            newOne.x = (l.x-len<=0)?1:l.x-len;
        }
        if(dir==3) {
            newOne.x = l.x;
            newOne.y = (l.y-len<=0)?1:l.y-len;
        }
        if(dir==4) {
            newOne.y = l.y;
            newOne.x = (l.x+len>map_X)?map_X:l.x+len;
        }
        return newOne;
    }

    // 按照时间顺序排序操作，并返回最大时间值
    public static int sortActionsByTime() {
        int len = actions.length;
        for(int i=0;i<len-1;i++) {
            for(int j=0;j<len-(i+1);j++) {
                if(!isTimed(actions[j], actions[j+1])) {
                    Operation tmp = actions[j];
                    actions[j] = actions[j+1];
                    actions[j+1] = tmp;
                }
            }
        }
        return actions[actions.length-1].time;
    }

    // 比较时间，顺时为true，逆时为false
    public static boolean isTimed(Operation a, Operation b) {
        if(a.time > b.time) {
            return false;
        } else {
            return true;
        }
    }
}
