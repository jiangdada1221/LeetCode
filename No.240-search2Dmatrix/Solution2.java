// fastest and  i should keep in mind this kind of search (just 排除 half for one time(binarysearch)
/* this is O(m+n) firstly I choose the right-top element
    if target is greater than right-top , it must be below to right-top!
    if target is smaller , it must be left to right-top!
 */
public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target){
        if (matrix.length==0 || matrix[0].length == 0) return false;
        int i = matrix.length-1;
        int j = 0;
        int length = matrix[0].length;
//        if (matrix[i][j] == target) return true;
        while (i>=0 && j< length){
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) i--;
            else j++;
        }
        return false;

    }
}
