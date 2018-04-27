/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

/*
下面这种做法只是适用于输入链表变为整数后在int范围内的情况，正确做法在Solution2_1中
 */
public class Solution2 {
    public static void main(String[] args) {
        show(intToList(3432));
        System.out.println();
        System.out.print(listToInt(intToList(3432)));
    }
    public static void show(ListNode l) {
        while (l != null) {
            System.out.print(l.val + "-");
            l = l.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int total = listToInt(l1) + listToInt(l2);
        return intToList(total);
    }

    public static int listToInt(ListNode l) {
        int i = 0;
        int k = 1;
        while (l != null) {
            i = i + l.val * k;
            l = l.next;
            k = k * 10;
        }
        return i;
    }
    public static ListNode intToList(int i) {
        ListNode head = null;
        ListNode current = null;
        int tail = 0;
        while (true) {
            tail = (int)(i % 10);
            i = i / 10;
            ListNode l = new ListNode(tail);

            if (head == null) {
                head = l;
                current = l;
            }
            else {
                current.next = l;
                current = current.next;
            }

            if (i == 0)
                break;
        }

        return head;
    }
    static class ListNode {
        public int val;
        ListNode next;
        ListNode (int x) { val = x; }
    }


}

