import java.util.*;

public class day58 {
    public static boolean ContainsDuplicateII(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        for(int i=0; i<n; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            // sliding window in comes the right ele
            set.add(nums[i]);

            if(set.size() > k) {
                set.remove(nums[i-k]);
                //sliding window so out goes the last value; left sided
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        boolean result = ContainsDuplicateII(nums, k);
        System.out.print(result);
        sc.close();
    }
}
