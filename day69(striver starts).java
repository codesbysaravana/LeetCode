char day69() {
    main() {
        /STRIVER START;
    }
}



class Solution {
    public int subarraySum(int[] nums, int k) {
        // Map to store (prefixSum → frequency)
        Map<Integer, Integer> map = new HashMap<>();

        // map.put(0, 1) means:
        // If prefix sum = 0, it occurred once initially.
        // This covers subarrays starting from index 0 itself whose sum = k.
        map.put(0, 1);

        int preSum = 0;  // To store running prefix sum
        int count = 0;   // To count valid subarrays

        for (int i = 0; i < nums.length; i++) {
            // Add current element to running prefix sum
            preSum = preSum + nums[i];

            // "remove" is the key idea:
            // We want subarrays where sum = k
            // So, preSum - k = some previous prefix sum
            // Example:
            // if preSum = 9 and k = 5, we look for 9 - 5 = 4
            // meaning there was a previous prefixSum = 4
            // between that prefix and now → subarray sum = 5
            int remove = preSum - k;

            // Add the count of such previous prefix sums (if any)
            // If not found, getOrDefault gives 0
            count = count + map.getOrDefault(remove, 0);

            // Store the current prefix sum in the map
            // If it already exists, increment its frequency
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}
