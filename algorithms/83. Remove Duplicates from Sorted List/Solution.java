/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
            
        ListNode listNode = head;  //负责“穿针引线”，将需要的节点链接在一起
        ListNode current = head;  //负责遍历链表
        while (current != null) {     
            if (listNode.val != current.val) {
                listNode.next = current;
                listNode = listNode.next;              
            }
            current = current.next; 
        }
        listNode.next = null;
        return head; 
    }
}