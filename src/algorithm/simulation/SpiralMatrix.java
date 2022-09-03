package algorithm.simulation;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] m = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.spiralOrder(m);
    }

    int[][] m;
    direct nowDirect=direct.RIGHT;
    boolean[][] visited;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>(matrix.length*matrix[0].length);
        m=matrix;
        visited=new boolean[m.length][m[0].length];
        loc start=new loc(0,0);//start
        res.add(m[0][0]);
        visited[0][0]=true;
        while(getNext(start)){
            res.add(matrix[start.y][start.x]);
            visited[start.y][start.x]=true;
        }
        return res;
    }

    private boolean getNext(loc now){
        if(!open(now)){
            return false;
        }
        if(nowDirect==direct.RIGHT){
            if(now.x+1==m[0].length||visited[now.y][now.x+1]){
                nowDirect=direct.DOWN;
            }
        } else if(nowDirect==direct.DOWN){
            if(now.y+1==m.length||visited[now.y+1][now.x]){
                nowDirect=direct.LEFT;
            }
        } else if(nowDirect==direct.LEFT){
            if(now.x-1==-1||visited[now.y][now.x-1]){
                nowDirect=direct.UP;
            }
        } else if(nowDirect==direct.UP){
            if(now.y-1==-1||visited[now.y-1][now.x]){
                nowDirect=direct.RIGHT;
            }
        }

        if(nowDirect==direct.RIGHT){
            now.x++;
        }
        if(nowDirect==direct.DOWN){
            now.y++;
        }
        if(nowDirect==direct.LEFT){
            now.x--;
        }
        if(nowDirect==direct.UP){
            now.y--;
        }

        return true;
    }

    private boolean open(loc now){
        int x=now.x;
        int y=now.y;
        if(x+1<m[0].length&&!visited[y][x+1]){
            return true;
        }
        if(x-1>=0&&!visited[y][x-1]){
            return true;
        }
        if(y+1<m.length&&!visited[y+1][x]){
            return true;
        }
        if(y-1>=0&&!visited[y-1][x]){
            return true;
        }
        return false;
    }

    enum direct{
        LEFT,
        RIGHT,
        UP,
        DOWN;
    }

    class loc{
        int x;
        int y;
        loc(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
