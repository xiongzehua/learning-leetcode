package com.xiongzehua.learning.java;

/**
 * Created by xiongzehua on 2018/6/21.
 */
import org.junit.Test;

        import java.util.LinkedList;
        import java.util.List;
public class Solution {
    @Test
    public void test() {
        List list = generateParenthesis(8);
        System.out.println(list);
    }
    public List<String> generateParenthesis(int n) {
        Single.lev = n * 2;
        Node root = new Node(0, 0, 0, null);
        buildTree(root);

        LinkedList<String> list = new LinkedList<String>();

        for (Node node : Single.list) {
            StringBuilder sb = new StringBuilder();
            while(node != root) {
                sb.append(node.getParenthesis());
                node = node.prev;
            }
            list.add(sb.reverse().toString());
        }
        return list;
    }
    /**
     * 递归生成子二叉树
     *
     * @param node 传入一个节点，构建这个节点的左右子树
     */
    public void buildTree(Node node) {
        if (node.target > 0)
            return;

        if (node.lev >= Single.lev) {
            if (node.target == node.value) {
                Single.list.add(node);
                System.out.println(node);
            }
            return;//无需继续递归了
        }

        int newTarget = node.target - node.value;
        int newLev = node.lev + 1;


        node.left = new Node(1, newLev, newTarget, node);
        buildTree(node.left);


        node.right = new Node(-1, newLev, newTarget, node);
        buildTree(node.right);

    }
}
class Single {
    static int lev;
    static LinkedList<Node> list =  new LinkedList<Node>();
}
class Node {
    int value;
    int lev;
    int target;
    Node prev;
    Node left;
    Node right;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", lev=" + lev +
                ", target=" + target +
                '}';
    }

    public Node(int value, int lev, int target, Node prev) {
        this.value = value;
        this.lev = lev;
        this.target = target;
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