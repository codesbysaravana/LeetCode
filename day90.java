import java.util.*;

class day90 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(numbers[i], i);
        }
        return new int[] {};
    }
}

/* 
Traverse the array once
Use a HashMap to remember numbers we’ve already seen
For each number, check: “Have I already seen the number that completes my target?”
 */

 //  we want non uniques too