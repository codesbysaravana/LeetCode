//HAS CYCLE ---> FLOYDS CYCLE ---> SLOW AND FAST POINTER

import java.util.*;

class ListNode {
    int data;
    ListNode next, head;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class day79 {
    public static Boolean Brute_LLCycled(ListNode head) {
        ListNode temp = head;
        Set<ListNode> set = new HashSet<>();
        
        while(temp != null) {
            if(!set.add(temp)) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }


    public static Boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) return true;
        }

        return false;
    }

















    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        for (int i = 1; i < n; i++) {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        temp.next = head;

        System.out.println(Brute_LLCycled(head));

        sc.close();
    }
}

}
