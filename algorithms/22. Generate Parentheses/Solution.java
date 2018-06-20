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
class Solution {
    public List<String> generateParenthesis(int n) {
        Node root = new Node();
        root.prev = null;
        root.value = 1;
        
    }
    /**
     * 递归生成子二叉树
     *
     * @param root 这颗子二叉树的根
     * @param lev root的层级，初始时root为1，root <= 2*n
     * @param target 这颗子二叉树每一个分支目标和
     */
    public void buildTree(Node root, int lev, int target) {
        
    }
}
class Node {
    int value;
    Node prev;
    Node left;
    Node right;
    public String getParenthesis() {
        if (value == 1)
            return "(";
        else if (value == -1)
            return ")";
        else
            return null;
    }
}