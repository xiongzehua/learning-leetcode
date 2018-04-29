/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

_0版本为链表新增节点的标准范式写法。
此版本为在_0版本基础上不new对象，用原有节点构建新链表。
 */
public class Solution21_2 {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;

        ListNode newNode = null;
        while (true) {
            //创建节点预备工作
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    newNode = l1;
                    l1 = l1.next;
                } else {
                    newNode = l2;
                    l2 = l2.next;
                }
            } else if (l1 != null && l2 == null) {
                newNode = l1;
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                newNode = l2;
                l2 = l2.next;
            } else {
                break;
            }

            //新增节点范式，此时current指向除新增节点外最新的节点
            if (head == null) {
                head = newNode;
                current = newNode;
            }
            else {
                current.next = newNode;//先把newNode链接上去
                current = current.next;//current右移一位指向最新的
            }
        }
        return head;
    }
}
