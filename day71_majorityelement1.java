import java.util.*;

public class day71_majorityelement1 {
        public int majorityElementBRUTE(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(nums[j] == nums[i]) {
                    count++;
                }
                if(count>n/2) { return nums[i]; }
            }
        }

        return 0;
    }

    public int bettermap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }
        
        int check = nums.length/2;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getkey();
            int value = entry.getvalue();

            if(value > check) {
                return key;
            }
        } 

        return 0;
    }

    public int MooresVotingAlgorithm(int[] nums) {
        int count = 0;
        int ele = 0;
        int n = nums.length;

        //Check for majority element
        for(int i=0; i<n; i++) {
            if(count == 0) {
                ele = nums[i];
                count++;
            } else if(ele == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        
        //validate the checked
        int count2 = 0;
        int res = n/2;
        for(int i=0; i<n; i++) {
            if(nums[i] == ele) {
                count2++;
            }
        }

        if(count2 > res) {
            return ele;
        }

        return 0;
    }

}

//map.put(//key, //if-key-present-getcountof-key-+1-or-0)