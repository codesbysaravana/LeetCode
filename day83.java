import java.util.*;

class day83 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while(temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        temp = head;
        int left = 0;
        int right = list.size()-1;

        while(left < right) {
            if(list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

// logic
// put all ListNodes in List
// get List size and use left right pointers and check list,get check both, normal logic





// Key Idea
/* 
Use slow & fast pointers, then reverse half of the list in-place.

Steps
Find the middle of the linked list
Reverse the second half
Compare first half & second half
*/



class Solutioooon {
    public static boolean isPalindromeOptmiized(ListNode head) {
        if(head == null && head.next == null) return false;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null;
        while(slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        //3. Compare
        ListNode right = prev;
        ListNode left = head;
        while(right != null) {
            if(left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        return false;
    }
}