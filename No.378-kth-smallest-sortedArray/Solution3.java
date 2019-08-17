class Solution3 {
    /* this is very very brilliant!
        binarysearch smallest,biggest  define a mid count the number of smaller elements than mid
        update low and high
        !!if mid is little higher than result(in matrix),high=mid then the count(nextmid)will be less (or equal then high=mid again)
        then low=mid+1 if low and high is not the value in matrix it will continue updating
     */
    private int count(int a[][], int target) {
        int i = a.length - 1, j = 0;
        int c = 0;
        while (i >= 0 && j < a.length) {
            if (a[i][j] <= target) {
                c += i + 1;
                j++;
            } else
                i--;
        }
        return c;     // c is the number of elements smaller than target
    }

    public int kthSmallest(int[][] matrix, int k) {

        int l = matrix[0][0], h = matrix[matrix.length - 1][matrix.length - 1];

        while (l < h) {
            int mid = l + ((h - l) >> 1);   //equals to l+(h-l)/2
            if (count(matrix, mid) < k) {
                l = mid + 1;
            } else
                h = mid;     // why mid is in matrix??
        }

        return h;

    }

    public static void main(String[] args) {
        int[][] array3 = new int[][]{{1,2,3,7},{5,10,14,16},{8,10,18,19},{9,12,22,24}} ;

        Solution3 so3 = new Solution3();
        System.out.println(so3.kthSmallest(array3,3));
    }
}