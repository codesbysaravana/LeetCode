import java.util.Scanner;

public class day57 {
    public static double MaxAvgSubArray(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        for(int i=0; i<k; i++) {
            sum = sum+nums[i];
        }

        double maxLen = sum;
        for(int i=k; i<n; i++) {
            sum = sum + nums[i] - nums[i=k]; // prev out and new in;
            maxLen = Math.max(maxLen, sum);
        }   

        return maxLen /k; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the length of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            System.out.println("Enter element:");
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter max Avg Subarray");
        int k = sc.nextInt();

        double result = MaxAvgSubArray(nums, k);
        System.out.println(result);

        sc.close();
    }    
}
