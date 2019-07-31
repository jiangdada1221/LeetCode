public class Solution2 {

    /* I forget whether this one is right */
    public boolean find132small(int[] nums) {
        int indexF,indexM,indexL;
        int small = nums[0];
        for (indexF = 0;indexF<=nums.length-3;indexF++) {
            if  (indexF >=1){
                if  (nums[indexF] == small)
                    continue;
            }int middle = nums[indexF+1];
            for (indexM = indexF+1;indexM<=nums.length-2;indexM++) {
                if  (indexM >= indexF+2){
                    if  (nums[indexM] == middle)
                        continue;
                }int last = nums[indexM+1];
                if (nums[indexF]< nums[indexM]) {

                    for (indexL = indexM+1;indexL<=nums.length-1;indexL++){
                        if(indexL >= indexM+2){
                            if(nums[indexL] == last)
                                continue;
                        }
                        if (nums[indexL] > nums[indexF] && nums[indexL]<nums[indexM])
                            return true;
                    }
                }middle = nums[indexM];
            }
            small = nums[indexF];
        }
        return false;
    }
}
