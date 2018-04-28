/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */


public class Solution2_1 {
    public static void main(String[] args) {
    }
    public static void show(ListNode l) {
        while (l != null) {
            System.out.print(l.val + "-");
            l = l.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode total = null;
        ListNode currentTotal = null;
        ListNode current1 = l1;
        ListNode current2 = l2;

        int carry = 0;

        while(true) {
            int i = 0;
            if (current1 != null && current2 != null) {
                i = current1.val + current2.val + carry;
                current1 = current1.next;
                current2 = current2.next;

            } else if (current1 == null && current2 != null) {
                i = current2.val + carry;
                current2 = current2.next;

            } else if (current1 != null && current2 == null) {
                i = current1.val + carry;
                current1 = current1.next;

            } else {
                if (carry == 1)
                    i = carry;
                else
                    break;
            }

            if (i >= 10) {
                i = i - 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode node = new ListNode(i);

            if (total == null) {
                total = node;
                currentTotal = total;
            } else {
                currentTotal.next = node;
                currentTotal = currentTotal.next;
            }
        }
        return total;
    }
    static class ListNode {
        public int val;
        ListNode next;
        ListNode (int x) { val = x; }
    }


}


