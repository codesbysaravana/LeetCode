class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;

        for(int i=0; i<nums.length; i++) {
            if(sum == 0) {
                start = i;
            }

            sum = nums[i] + sum;

            if(sum > maxSum) {
                maxSum = sum;
                int ansStart = start;
                int ansEnd = i;
            }

            if(sum < 0) {
                sum = 0;
            }
        } 

        return maxSum;
    }
}

