package algorithm.graphicscomputing;

// url:https://leetcode.cn/problems/rotate-image/
public class RotateSquareMatrix {


    int[][] m;
    boolean[][] visited;

    public void rotate(int[][] matrix) {
        m=matrix;
        int len=matrix.length;
        visited=new boolean[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                swap(new loc(i,j), new loc(j,i));
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                visited[i][j]=false;
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                swap(new loc(i,j), new loc(len-1-i,j));
            }
        }
    }

    private void swap(loc a, loc b){
        if(!visited[a.y][a.x]&&!visited[b.y][b.x]){
            int tmp=m[a.y][a.x];
            m[a.y][a.x]=m[b.y][b.x];
            m[b.y][b.x]=tmp;
            visited[a.y][a.x]=true;
            visited[b.y][b.x]=true;
        }
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
