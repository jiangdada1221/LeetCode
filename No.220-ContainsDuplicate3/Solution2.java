import java.util.SortedSet;
import java.util.TreeSet;
/* subset 方法应该是log(k) runtime this is O(nlogk) */
public class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1 || t < 0) {
            return false;
        }
        TreeSet<Long> window = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            SortedSet<Long> set = window.subSet((long) nums[i] - t, true, (long) nums[i] + t, true);
            if (!set.isEmpty()) {
                return true;
            } else {
                if (i >= k) {
                    window.remove((long) nums[i - k]);
                }
                window.add((long) nums[i]);
            }
        }
        return false;
    }
}