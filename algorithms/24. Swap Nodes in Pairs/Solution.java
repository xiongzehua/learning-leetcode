/*
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        //新增空节点作为头节点，增加统一性
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        
        ListNode current = headNode;
        while(current != null && current.next != null && current.next.next != null) {
            //若要交换1号节点和2号节点，需要1节点的前节点，不然会丢失与前面链表的链接。
            //current作为1号节点和2号节点的前节点。
            ListNode firstNode = current.next;
            ListNode secondNode = current.next.next;
            
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            current.next = secondNode;
            
            current = current.next.next;
        }
        return headNode.next;
    }
}