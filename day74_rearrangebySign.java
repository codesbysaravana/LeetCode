import java.util.*;

class day74_rearrangebySign {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }

        int[] arr = new int[n];
        int p = 0; // pointer for positive list
        int g = 0; // pointer for negative list

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = pos.get(p);
                p++;
            } else {
                arr[i] = neg.get(g);
                g++;
            }
        }

        return arr;
    }
}



class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        int posIndex = 0;
        int negIndex = 1;

        int ans[] = new int[n];
        for(int i=0; i<n; i++) {
            if(nums[i] > 0) {
                ans[posIndex] = nums[i];
                posIndex = posIndex + 2;
            }
            else {
                ans[negIndex] = nums[i];
                negIndex = negIndex + 2;
            }
        }

        return ans;
    }
}




class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Separate positives and negatives
        for (int ele : nums) {
            if (ele > 0) {
                pos.add(ele);
            } else {
                neg.add(ele);
            }
        }

        int p = 0;
        int g = 0;
        int idx = 0;

        // CASE 1: pos == neg  
        if (pos.size() == neg.size()) {
            while (p < pos.size() && g < neg.size()) {
                nums[idx++] = pos.get(p++);
                nums[idx++] = neg.get(g++);
            }
        }

        // CASE 2: pos > neg
        else if (pos.size() > neg.size()) {
            while (g < neg.size()) {
                nums[idx++] = pos.get(p++);
                nums[idx++] = neg.get(g++);
            }
            while (p < pos.size()) {
                nums[idx++] = pos.get(p++);
            }
        }

        // CASE 3: neg > pos
        else {
            while (p < pos.size()) {
                nums[idx++] = pos.get(p++);
                nums[idx++] = neg.get(g++);
            }
            while (g < neg.size()) {
                nums[idx++] = neg.get(g++);
            }
        }

        return nums;
    }
}
