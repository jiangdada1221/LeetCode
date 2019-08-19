
import java.util.HashSet;
/* !!! return value for set.add is boolean not void!! */
// however just sort the array first then iterate trough is faster 
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0;i<=nums.length-1;i++)
            if (!hs.add(nums[i])) return true;


        return false;
    }
}
