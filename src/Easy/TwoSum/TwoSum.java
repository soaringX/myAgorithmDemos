package Easy.TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
 * @Author: xjp
 * @Date: 2019/2/20
 */

public class TwoSum {
    public static void main(String[] args) {
        try {
            Map map = twoNum_3(new int[]{1, 2, 3, 4, 5}, 6);
            System.out.println(map.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @Description: 暴力解法 时间复杂度O(n2),空间复杂度O(n)
     * @Param: [Nums, target]
     * @return: int[]
     * @Author: xjp
     * @Date: 2019/2/20
     */
    public static Map twoNum_1(int[] Nums, int target) throws Exception {
        Map<String, Object> result = new HashMap();
        for (int i = 0; i < Nums.length; i++) {
            for (int j = i + 1; j < Nums.length; j++) {
                if (Nums[j] == target - Nums[i]) {
                    result.put(i + "j" + j, new int[]{i, j});
                }
            }
        }
        return result;
    }

    /**
     * @Description: 两遍hash表  时间复杂度O(n),空间复杂度O(n)
     * @Param: [Nums, target]
     * @return: java.util.Map
     * @Author: xjp
     * @Date: 2019/2/20
     */
    public static Map twoNum_2(int[] Nums, int target) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        Map<String, Object> result = new HashMap();
        for (int i = 0; i < Nums.length; i++) {
            map.put(Nums[i], i);
        }

        for (int i = 0; i < Nums.length; i++) {
            int complement = target - Nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                result.put(i + "下标数组为:" + map.get(complement), Arrays.toString(new int[]{i, map.get(complement)}));
            }
        }
        return result;
    }

    /**
     * @Description: 一遍哈希表 时间复杂度O(n),空间复杂度O(n)
     * @Param: [Nums, target]
     * @return: java.util.Map
     * @Author: xjp
     * @Date: 2019/2/20
     */
    public static Map twoNum_3(int[] Nums, int target) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        Map<String, Object> result = new HashMap();
        for (int i = 0; i < Nums.length; i++) {
            int complement = target - Nums[i];
            if (map.containsKey(complement)) {
                result.put(i + "下标集合为:", Arrays.toString(new int[]{map.get(complement), i}));
            }
            map.put(Nums[i], i);
        }
        return result;
    }
}

