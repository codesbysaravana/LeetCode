public class day62 {
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while(left <= right) {
            int mid = left + (right - left) /2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        day62 obj = new day62();
        int[] nums = {1,1,2,4,5};
        int target = 9;

        int result = obj.binarySearch(nums, target);
    }
}