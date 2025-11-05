import java.util.HashMap;
import java.util.Map;

class day64 {
    public static int binarynumSubArrayswithNum(int[] nums, int goal) {
        return atmost(nums, goal) - atmost(nums, goal-1);
    }
    
    private static int atmost(int[] nums, int goal) {
        int left = 0;
        int count = 0;
        int sum = 0;

        for(int right = 0; right<nums.length; right++) {
            sum = sum - nums[right];

            while(sum > goal) {
                sum = sum - nums[left];
                left++;
            }

            count = count + (right - left+1);
        }

        return count;
    }
}


public int numSubarraysWithSum(int[] nums, int goal) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int sum = 0, res = 0;

    for (int n : nums) {
        sum = sum + n;
        if (map.containsKey(sum - goal)) {
            res += map.get(sum - goal);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return res;
}
