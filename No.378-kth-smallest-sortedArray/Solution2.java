import java.util.PriorityQueue;

/* is this succeed it will be O(klog(n)) /using priority queue  that is very bad in practice!!*/
public class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(0,0,matrix[0][0]));
        k--;
        node toPut1,toPut2;
          // in order to keep kth smallest in the queue
        while (k>0) {
            node n = pq.poll();
            k--;
            if (n.x <= length-2){
                toPut1 = new node(n.x+1,n.y,matrix[n.x+1][n.y]);

                if (!pq.contains(toPut1)){

                    pq.add(toPut1);

                }}
            if (n.y <= length -2) {
                toPut2 = new node(n.x, n.y + 1, matrix[n.x][n.y + 1]) ;

                if (!pq.contains(toPut2)){

                    pq.add(toPut2);

            }}
        }
        return pq.peek().value;
    }
    private class node implements Comparable{
        int x,y,value;

        node(int x, int y,int value) {
            this.x=x;
            this.y=y;
            this.value = value;

        }

        @Override
        public int compareTo(Object o) {
            node n = (node) o;
            if (this.value == n.value){
                if (this.x == n.x)
                    return this.y-n.y;
                return this.x - n.x;
            }
            return this.value - n.value;
        }
        @Override
        public boolean equals(Object o) {
            node n = (node) o;
            if (this.x==n.x&&this.y==n.y) return true;
            return false;
        }
    }

    public static void main(String[] args) {
//        int[][] array = new int[][]{{3,5,9,9,9},{5,8,13,13,16},{10,10,14,14,16},{15,18,20,24,26},{20,24,29,32,37}};
//
//        int[][] array2 = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        int[][] array3 = new int[][]{{1,2,3,7},{5,10,14,16},{8,10,18,19},{9,12,22,24}} ;

        Solution2 so2 = new Solution2();
//        System.out.println(so2.kthSmallest(array3,8));
        for (int i = 1;i<=16;i++) {
            System.out.println(so2.kthSmallest(array3,i));
        }
    }
}
