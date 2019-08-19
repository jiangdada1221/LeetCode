import java.util.HashSet;
/* faster than 96.81 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0;i<=nums.length-1;i++) {
            if (!hs.add(nums[i])) return true;
            if (i>=k){
                hs.remove(nums[i-k]);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1,2,3,1};
        int[] test2 = new int[]{1,0,1,1};
        int[] test3 = new int[]{1,2,3,1,2,3};
        Solution so = new Solution();
        System.out.println(so.containsNearbyDuplicate(test1,3));
        System.out.println(so.containsNearbyDuplicate(test2,1));
        System.out.println(so.containsNearbyDuplicate(test3,2));
    }
}
