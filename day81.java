//21. Merge Two Sorted Lists

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class day81 {
    public ListNode mergeTwoListsBRUTEFORCED(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;

        if (l1 == null && l2 == null) return null;

        List<Integer> list = new ArrayList<>();

        while (l1 != null) {
            list.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            list.add(l2.val);
            l2 = l2.next;
        }

        Collections.sort(list);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : list) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }
}












//Step 2️⃣ Ask the first critical question
//❓ Since both lists are sorted, where will the smallest element always be?

//Answer:
//At the head of either list
//Never in the middle.
//This is the key observation.



//KEY IDEA:::::::::::::::::::
/* 
Step 3️⃣ How do humans do this naturally?
Imagine:
List 1:
1 → 3 → 5

List 2:
2 → 4 → 6

What would you do?
You would:

Look at 1 and 2
Pick 1
Move forward in list 1
Compare 3 and 2
Pick 2
Move forward in list 2

You never look back.
You never sort again.
 */






class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Handle edge cases
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode l1 = list1;
        ListNode l2 = list2;
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else { // values equal
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;

                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // Attach remaining nodes
        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;

        return dummy.next;
    }
}

//QnA to ask
// 1. What if vals are equal??
// 2. what if looop one ends at t1 bull and t2 value?? 