package algorithm;

public class CheckZeroSurrend {

    public static void main(String[] args) {
        char[][] map = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        solve(map);
    }

    public static void solve(char[][] b) {
        int high=b.length;
        int width=b[0].length;
        if (high == 0) {
            return;
        }
        for(int i=0;i<width;i++){
            dfs(width,high,i,0,b);
            dfs(width,high,i,high-1,b);
        }
        for(int i=1;i<high-1;i++){
            dfs(width,high,0,i,b);
            dfs(width,high,width-1,i,b);
        }
        for(int i=0;i<width;i++){
            for(int j=0;j<high;j++){
                if (b[j][i] == 'A') {
                    b[j][i] = 'O';
                } else if (b[j][i] == 'O') {
                    b[j][i] = 'X';
                }
            }
        }
    }

    private static void dfs(int w, int h, int x, int y, char[][] b){
        if(x<0||x>=w||y<0||y>=h||b[y][x]!='O'){
            return;
        }
        b[y][x]='A';

        dfs(w,h,x+1,y,b);
        dfs(w,h,x-1,y,b);
        dfs(w,h,x,y+1,b);
        dfs(w,h,x,y-1,b);
    }
}
