public class day60 {
    public static int Longest1safterzeroremoval(int[] nums) {
        int maxLen = 0;
        int left = 0;
        int zeroCount = 0;
        for(int right = 0; right<nums.length; right++) {
            if(nums[right] == 0) {
                zeroCount++;
            }

            while(zeroCount>1) {
                if(nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, (right-left+1) -1);

            //-1 for zeroo taken out
        }
    }
}

/* 

You’re keeping a sliding window of at most one zero.

Whenever there are two zeros, you slide left until only one zero remains.

(right - left + 1) gives the window length, but we subtract one because the problem requires deleting one element (either that single zero or a one).

The result is the maximum length of consecutive 1s after deleting one element. */