import java.util.Arrays;

/* O(n^2) iterate and sort it space:O(n^2)*/
public class Solution {
    public int kthSmallest(int[][] matrix,int k) {
        int[] result = new int[matrix.length*matrix[0].length];
        for (int i = 0;i<=matrix.length;i++) {
            for (int j = 0;j<=matrix[0].length;j++) {
                result[i*matrix.length + j] = matrix[i][j];
            }
        }
        Arrays.sort(result);
        return result[k-1];
    }

    public static void main(String[] args) {

    }
}
