import java.util.Stack;

class ListNode {
    int data;
    ListNode prev;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Day77_RevADLL {

    // Reverse DLL using Stack (data reversal)
    public static ListNode reverseDLLUsingStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            temp.data = stack.peek();
            stack.pop();
            temp = temp.next;
        }

        return head;
    }

    // Print DLL
    public static void printDLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

        // Values to insert
        int[] values = {10, 20, 30, 40};

        // Create DLL using loop
        ListNode head = null;
        ListNode tail = null;

        for (int val : values) {
            ListNode newNode = new ListNode(val);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        System.out.println("Original DLL:");
        printDLL(head);

        head = reverseDLLUsingStack(head);

        System.out.println("Reversed DLL (Stack):");
        printDLL(head);
    }
}
