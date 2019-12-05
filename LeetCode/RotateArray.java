package algorithm;

/**
 * Time: 2019-12-05
 * Author:
 * Mail:
 * Description:
 */
public class RotateArray {

    /**
     * 暴力旋转
     * 时间复杂度：O(n*k)O(n∗k) 。每个元素都被移动 1 步（O(n)O(n)） k次（O(k)O(k)） 。
     * 空间复杂度：O(1)O(1) 。没有额外空间被使用。
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int previous = 0;
        int temp = 0;
        for (int i = 0; i < k; i ++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 使用额外的数组
     * 时间复杂度： O(n)O(n) 。将数字放到新的数组中需要一遍遍历，另一边来把新数组的元素拷贝回原数组。
     * 空间复杂度： O(n)O(n)。另一个数组需要原数组长度的空间。
     *
     * @param nums
     * @param k
     */
    public void rotate_1(int[] nums, int k) {
        int[] tempArray = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            tempArray[(i + k) % nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = tempArray[i];
        }
    }

    /**
     * 环状替换
     * 时间复杂度：O(n)O(n) 。只遍历了每个元素一次。
     * 空间复杂度：O(1)O(1) 。使用了常数个额外空间。
     *
     * 环状替换确实比较难理解。如果把数组的数据放在正多边形上，以走跳棋的思路替换数据，画个图就好理解了。
     * 假如 n=5, k=2, 数字1-5依次放在五边形顶点，数字替换的轨迹是1-3-5-2-4-1，回到原点，count = n， 结束。轨迹画出来刚好是个五角星。
     * 假如 n=6, k=2, 数字1-6依次放在六边形顶点，数字替换的轨迹是1-3-5-1，回到原点了，count < n, start++, 接着 2-4-6-2，回到原点，count = n, 结束。轨迹是六边形的2个内嵌正三角形。
     *
     * 其它多边形类似，隔k个点往前走，总能走回原点，如果中间有漏的，旋转一个角的方位重复进行上述步骤就能走完所有的顶点了。
     *
     * @param nums
     * @param k
     */
    public void rotate_2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    /**
     * 反转
     * 时间复杂度：O(n)O(n) 。 nn 个元素被反转了总共 3 次。
     * 空间复杂度：O(1)O(1) 。 没有使用额外的空间。
     * @param nums
     * @param k
     */
    public void rotate_3(int[] nums, int k) {
        //获取实际需要旋转数
        k %= nums.length;

        //反转所有数组内容
        reverse(nums, 0, nums.length - 1);
        //反转前k个数
        reverse(nums, 0, k - 1);
        //反转后n-k个数
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
