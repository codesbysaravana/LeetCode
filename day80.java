import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();

        ListNode temp = head;
        while (temp != null) {
            set.add(temp.val);
            temp = temp.next;
        }

        List<Integer> list = new ArrayList<>(set);
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



public class day80 {
    public static ListNode buildList(int n, Scanner sc) {
        if (n == 0) return null;

        ListNode head = new ListNode(sc.nextInt());
        ListNode curr = head;

        for (int i = 1; i < n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ListNode head = buildList(n, sc);

        Solution sol = new Solution();
        ListNode result = sol.deleteDuplicates(head);

        printList(result);
        sc.close();
    }
}












/* 
1 → 1 → 2 → 3 → 3 → 4
Duplicates are:Adjacent
Right next to each other
Detectable by comparing neighbor
👉 You don’t need to remember all past values */









//OPTIMZIED
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while(curr != null && curr.next != null) {
            if(curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}