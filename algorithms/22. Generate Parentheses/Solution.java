/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

/*
用一颗二叉树来储存，1表示左括号，-1表示右括号。
规则：从根开始向下遍历，每遍历一个便求一次和，若这个分支和小于0则这个分支错误。
根是1，代表的是 "("
*/
import java.util.LinkedList;
import java.util.List;
class Solution {
    public List<String> generateParenthesis(int n) {
        Single.lev = n * 2;
        Node root = new Node(1, null);
        root.left = buildTree(new Node(1, root), 1, -1);
        root.right = buildTree(new Node(-1, root), 1, -1);
        
        LinkedList<String> list = new LinkedList<String>();

        for (Node node : Single.list) {
            String s = "";
            while(node == null) {
                s = s + node.getParenthesis();
            }
            list.add(s);
        }
        return list;
    }
    /**
     * 递归生成子二叉树
     *
     * @param node 这颗子二叉树的根,传入时根节点只有value，没有left和right
     * @param lev node的层级，初始时root为1，node层级 <= 2*n
     * @param target 这颗子二叉树每一个分支目标和
     */
    public Node buildTree(Node node, int lev, int target) {
        if (target > 0)
            return null;
        if (lev == Single.lev) {
            if (target == node.value)
                Single.list.add(node);
            return node;//无需继续递归了
        }  
        
        target = target - node.value;
        lev++;
        node.left = buildTree(new Node(1, node), lev, target);
        node.right = buildTree(new Node(-1, node), lev, target);
        return node;
    }
}
class Single {
    static int lev;
    static LinkedList<Node> list =  new LinkedList<Node>();
}
class Node {
    int value;
    Node prev;
    Node left;
    Node right;
    Node(int value, Node prev) {
        this.value = value;
        this.prev = prev;
    }
    public String getParenthesis() {
        if (value == 1)
            return "(";
        else if (value == -1)
            return ")";
        else
            return null;
    }
}