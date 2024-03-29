package java_test;

/**
 * Time: 2019-12-04
 * Author:
 * Mail:
 * Description:
 */
class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 1;
        while(j < nums.length) {
            if (nums[i] != nums[j]) {
                if (j - i > 1) {
                    nums[i + 1] = nums[j];
                }
                i++;
            }
            j++;
        }
        return i + 1;
    }
}
