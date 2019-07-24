import java.util.SortedSet;

public class Solution {  //DFS    15ms faster than 70% ; 44.4mb less than 99.82%
    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0;i<= matrix.length-1;i++) {
            for (int j = 0;j<=matrix[0].length-1;j++){
                if (matrix[i][j] == 0)
                    result[i][j] = 0;
                else result[i][j]  = 10001;
            }
        }
        for (int i = matrix.length-1;i>=0;i--) {
            for (int j = 0;j<=matrix[0].length-1;j++)
                scan(i,j,result,true);
        }
//        for (int i = 0;i<=matrix.length-1;i++) {
//            for (int j = 0;j<=matrix[0].length-1;j++)
//                scan(i,j,result,true);
//        }
        return result;
    }

    private int scan(int x, int y, int[][] matrix,boolean boo) {
        if (matrix[x][y] != 10001 && !boo)
            return matrix[x][y];
        if (matrix[x][y] == 0)
            return 0;
        int u = 10001;
        int d = 10001;
        int l = 10001;
        int r = 10001;
        matrix[x][y] = 10002;
        if (x<matrix.length-1 && matrix[x+1][y]!=10002)
            r =1+  scan(x+1,y,matrix,false);
        if (x>0 && matrix[x-1][y]!=10002)
            l = 1 + scan(x-1,y,matrix,false);
        if (y<matrix[0].length-1 && matrix[x][y+1]!=10002)
            u = 1 + scan(x,y+1,matrix,false);
        if (y>0 && matrix[x][y-1]!=10002)
            d = 1+scan(x,y-1,matrix,false);
        int result = Math.min(Math.min(u,d),Math.min(l,r));
        matrix[x][y] = result;
        if (inBound(x+1,y,matrix)&&matrix[x+1][y]>result+1)
            matrix[x+1][y] = result+1;
        if (inBound(x-1,y,matrix) && matrix[x-1][y]>result+1)
            matrix[x-1][y] = result+1;
        if (inBound(x,y+1,matrix) && matrix[x][y+1]>result+1)
            matrix[x][y+1] = result+1;
        if (inBound(x,y-1,matrix) && matrix[x][y-1]>result+1)
            matrix[x][y-1] = result+1;
        return result;
    }

    private boolean inBound(int x,int y , int[][] matrix) {
        if (x<0 || x >= matrix.length || y<0 || y >=matrix[0].length)
            return false;
        return true;
    }
    public static void main(String[] args) {
        Solution so = new Solution();
        int[][] matrix = new int[][]{{1,1,1,1},{1,1,1,1},{0,1,1,0}};
        int[][] matrix2 = so.updateMatrix(matrix);
//        for (int i = 0;i<=3;i++) {
//            for (int j = 0;j<=2;j++)
//                System.out.println(matrix2[i][j]);
//        }
    }

}
