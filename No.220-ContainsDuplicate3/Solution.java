/* very naive and is very slow O(N*k) */

public class Solution {

        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            for (int i = 0;i<= nums.length-1;i++) {
                for (int j = 1;j<=k;j++){
                    if (i+j > nums.length-1) break;
                    if (Math.abs((long)nums[i] - (long)nums[i+j]) <=(long) t) return true;
                }
            }
            return false;
        }


    public static void main(String[] args) {
//        int[] test1 = new int[]{1,2,3,1};
//        int[] test2 = new int[]{1,0,1,1};
//        int[] test3 = new int[]{1,5,9,1,5,9};
        int[] test4 = new int[]{-1,2147384647};
        Solution so = new Solution();
//        System.out.println(so.containsNearbyAlmostDuplicate(test1,3,0));
//        System.out.println(so.containsNearbyAlmostDuplicate(test2,1,2));
//        System.out.println(so.containsNearbyAlmostDuplicate(test3,2,3));
        System.out.println(so.containsNearbyAlmostDuplicate(test4,1,2147483647));
//        System.out.println(Math.abs((long)-1 - (long)2147483647));
    }
}
