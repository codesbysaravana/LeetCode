import java.util.*;

class Day82 {
    public ListNode deleteset(ListNode head) {
        if (head == null) return null;

        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: find duplicate values
        Set<Integer> set = new HashSet<>();
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                set.add(curr.val);
            }
            curr = curr.next;
        }

        // Step 2: remove all nodes with duplicate values
        curr = dummy;
        while (curr.next != null) {
            if (set.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}


/* 
Step 1 — Ask the right first question
When you’re at a node, don’t ask:
“Should I delete this node now?”

Ask instead:
“Do I have proof that this value is unique?”
If the answer is no, you are not allowed to keep it yet. */


/* 
🔑 Key Insight (this changes everything)
If a value appears more than once in a sorted list,
all its duplicates are NEXT TO EACH OTHER. */

//  So instead of remembering duplicates, we:
//  Detect a duplicate block
//  Skip the entire block
//thats why prev comes in to take em the block out!





class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = head;
        ListNode prev = dummy;

        while (curr != null) {
            if(curr.next != null && curr.val == curr.next.val) {
                //skip all nodes with same value
                while(curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
            }

            else {
                prev = prev.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
