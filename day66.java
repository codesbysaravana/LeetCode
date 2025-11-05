class day66 {
    public static void RemoveDuplicates(int[] nums) {
        int i=0;

        for(int num : nums) {
            if(num != 0) {
                nums[i] = num;
                i++;
            }
        }

        while(i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
}