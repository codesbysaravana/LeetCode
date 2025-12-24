import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;

        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null || p2 != null || carry != 0) {
            int sum = carry;

            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }

            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10); //curr.next = new ListNode(sum % 10);
            curr.next = newNode;
            curr = curr.next;
        }

        return dummy.next;
    }
}

public class day76_Add2LL {
    static ListNode buildList(Scanner sc) {
        System.out.print("Enter number of digits: ");
        int n = sc.nextInt();

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        System.out.println("Enter digits (REVERSED order):");
        for (int i = 0; i < n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }

        return dummy.next;
    }

    // Print linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== ADD TWO NUMBERS (LINKED LIST) ===");

        System.out.println("\nFirst Number:");
        ListNode l1 = buildList(sc);

        System.out.println("\nSecond Number:");
        ListNode l2 = buildList(sc);

        Solution sol = new Solution();
        ListNode result = sol.addTwoNumbers(l1, l2);

        System.out.println("\nResult:");
        printList(result);

        sc.close();
    }
}
