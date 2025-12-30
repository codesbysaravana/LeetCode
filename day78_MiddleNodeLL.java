// EASY PROBLEM - Find Middle of Linked List
import java.util.*;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class day78_MiddleNodeLL {

    public static ListNode insertAtEnd(ListNode head, int data) {
    if (head == null) {
        return new ListNode(data);
    }

    ListNode temp = head;
    while (temp.next != null) {
        temp = temp.next;
    }
    temp.next = new ListNode(data);
    return head;
}

    // Method to find middle node
    public static ListNode MiddleNode(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int half = count / 2;
        temp = head;

        while (half > 0) {
            temp = temp.next;
            half--;
        }

        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        if(n == 0) return;

        ListNode head = new ListNode(sc.nextInt());
        ListNode tail = head;

        for(int i=1; i<n; i++) {
            tail.next = new ListNode(sc.nextInt());
            tail = tail.next;
        }

        // Find middle node
        ListNode middle = MiddleNode(head);

        System.out.println("Middle Node Data: " + middle.data);

        sc.close();
    }
}














/* fast and slow pointer

two pointers ptr1 & ptr2

fast moves twice as FAST as slow 
slow moves at one step at time 

by the time fast has reached the end 
slow is at the middle 
 */

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}



