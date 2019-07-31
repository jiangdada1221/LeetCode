import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Arrays;

/* wrong , the first one I came across */
public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length <= 30)
            return find132small(nums);
        node[] nodeList = new node[nums.length];
        for (int i = 0;i<=nums.length-1;i++)
            nodeList[i] = new node(nums[i],i);
        Arrays.sort(nodeList);
        node small = nodeList[0];
        for (int i = 0;i<= nums.length-3;i++){
            if (i >= 1){
                if (small.compareTo(nodeList[i]) == 0)
                    continue;
            }
            int index = searchBigger(i+1,nodeList,nodeList[i]);
            if (index == -1) return false;
//            int start = Arrays.binarySearch(nodeList,new node(nums[i],i));
            node big = nodeList[index-1];
            for (int j = index;j<=nodeList.length-1;j++){
                if (nodeList[j].compareTo(big) == 0)
                    continue;
                int result = searchMiddle(i+1,j-1,nodeList,nodeList[i],nodeList[j]);    // big 里面也要search一遍
                if (result == -2) return true;
                big = nodeList[j];
        }small = nodeList[i];
        }
        return false;
    }

    private int searchBigger(int index, node[] nodeList,node n){
        for (int i = index;i<=nodeList.length-1;i++) {
            if (nodeList[i].compareTo(n) > 0)
                return i;
        }
        return -1;
    }

    private int searchMiddle(int start,int end,node[] nodeList,node small, node big){
        if (big.index<=small.index)
            return -1;
        for (int i = start;i<=end;i++) {
            if (nodeList[i].index > big.index && nodeList[i].compareTo(small)>0 && nodeList[i].compareTo(big)<0)
                return -2;
        }
        return -1;
    }

    private boolean find132small(int[] nums) {
        int indexF,indexM,indexL;
        for (indexF = 0;indexF<=nums.length-3;indexF++) {
            for (indexM = indexF+1;indexM<=nums.length-2;indexM++) {
                if (nums[indexF]< nums[indexM]) {
                    for (indexL = indexM+1;indexL<=nums.length-1;indexL++){
                        if (nums[indexL] > nums[indexF] && nums[indexL]<nums[indexM])
                            return true;
                    }
                }
            }
        }
        return false;
    }

    private class node implements Comparable<node>{
        int num;
        int index;
        node(int num, int index){
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(node o) {
            return this.num - o.num;
        }
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1,2,3,4};
        int[] test2 = new int[]{3,1,4,2};
        int[] test3 = new int[]{1,1,1,1,11,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        Solution so = new Solution();
        System.out.println(so.find132pattern(test1));
        System.out.println(so.find132pattern(test2));
        System.out.println(so.find132pattern(test3));
    }
}
