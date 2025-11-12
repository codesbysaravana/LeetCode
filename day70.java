import java.util.HashMap;
import java.util.Map;

public class day70 {
    public static int SubarraySumEqualsK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int count = 0; 
        int preSum = 0;

        for(int i=0; i<nums.length; i++) {
            preSum = nums[i] + preSum;

            int remove = preSum - k;
            
            //if sum = preSum - k ..is present in map ..increment the count of it or default new count 
            count = count + map.getOrDefault(remove, 0);

            //adding preSum as new with 0 count in map...or if preSum already present in map default value 0; 
            map.put(preSum, map.getOrDefault(preSum, 0) +1);

        }

        return count;        
    }
}
