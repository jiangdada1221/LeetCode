import java.util.HashMap;
/*Bucket. e.g. t=2, 就把(0,1,2)放在一个bucket, (3,4,5)放在下一个bucket等等.

当新的num mapped 到的bucket已经有数, 则return true. 并且检查上下各一个bucket. 上面的例子3-2=1也是小于t的.

这里负数也是允许的, -2/3 = 0, 2/3 = 0. -2 和 2 会map到一个bucket下面. 但2-(-2) = 4已经大于t了. 所以map时num都从Integer.MIN_VALUE开始计数.

另为了避免t=0的情况，求bucketNum时，除以(t+1).
remap 是因为要让负数也可以
注意要保持map里面的元素个数刚好为k（i>=k) 因为是先判断containskey再add的 意味着比的时候 比的元素就是第三个元素
*/
public class Solution3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
        if (nums == null || nums.length < 2 || k<1 || t<0) return false;
        HashMap<Long,Long> hm = new HashMap<>();
        for (int i = 0; i<nums.length;i++) {
            long remappedNum = (long)nums[i] - Integer.MAX_VALUE;
            long bucketNum = remappedNum / ((long)t + 1);
            if (hm.containsKey(bucketNum)||
                    (hm.containsKey(bucketNum-1)&& remappedNum - hm.get(bucketNum-1)<=(long)t)||
                    (hm.containsKey(bucketNum + 1)&&hm.get(bucketNum+1)-remappedNum <=(long) t)) return true;
            else {
                if (i>=k){
                    long firstBucket = ((long)nums[i-k] -Integer.MAX_VALUE)/((long)t +1);
                    hm.remove(firstBucket);
                }
                hm.put(bucketNum,remappedNum);
            }

        }
        return false;
    }
}
