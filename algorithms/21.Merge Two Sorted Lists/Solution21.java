/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

此解法为标准新增节点范式写法。
 */
public class Solution21 {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
    public ListNode MergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;

        int min = 0;
        while (true) {
            //创建节点预备工作
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    min = l1.val;
                    l1 = l1.next;
                } else {
                    min = l2.val;
                    l2 = l2.next;
                }
            } else if (l1 != null && l2 == null) {
                min = l1.val;
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                min = l2.val;
                l2 = l2.next;
            } else {
                break;
            }
            //创建新节点
            ListNode newNode = new ListNode(min);

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
