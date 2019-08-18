import java.util.Arrays;
/* naive approach runtime O(mlog(n))*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target){
        if (matrix.length == 0) return false;
        for (int i = 0;i<=matrix.length-1;i++) {
            if (matrix[i][0] <= target){
                if (Arrays.binarySearch(matrix[i],target) >=0) return true;
            }
        }
        return false;
    }
}
