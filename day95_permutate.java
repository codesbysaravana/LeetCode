import java.util.*;

public class day95_permutate
{
    public static void permutate(int[] nums, List<Integer> DS, List<List<Integer>> ans, boolean[] freq) {
        if(DS.size() == nums.length) {
            ans.add(new ArrayList<>(DS));
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(!freq[i]) {
                freq[i] = true;
                DS.add(nums[i]);
                permutate(nums, DS, ans, freq);
                DS.remove(DS.size() - 1);
                freq[i] = false;
            }
        }
    }
    
	public static void main(String[] args) {
	    int[] nums = { 1, 2, 3};
	    
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> DS = new ArrayList<>();
		boolean[] freq = new boolean[nums.length];
		
		permutate(nums, DS, ans, freq);
		
		System.out.println(ans);
	}
}