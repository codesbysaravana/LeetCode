import java.util.*;

class day65 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i =0;

        for(int j =1; j<nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }



    public int brute(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int index = 0;
        for(int num : nums) {
            if(!set.contains(num)) {
                set.add(num);
                nums[index++] = num;
            }
        }

        return index;
    }
}