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
        List list = generateParenthesis(3);
        System.out.println(list);
    }
    public List<String> generateParenthesis(int n) {
        Single.lev = n * 2;
        Node root = new Node(0, 0, 0, null);
        buildTree(root);

        System.out.println("-------------------");
        System.out.println("Single.lev: " + Single.lev);
        System.out.println("Single.list: " + Single.list);
        System.out.println("-------------------");

        LinkedList<String> result = new LinkedList<String>();
        for (Node node : Single.list) {
            StringBuilder sb = new StringBuilder();
            while(node != root) {
                sb.append(node.getParenthesis());
                node = node.prev;
            }
            result.add(sb.reverse().toString());
        }
        return result;
    }
    /**
     * 递归生成子二叉树
     * 若n为3，则最终生成的括号字符串的length为6
     * 括号字符串每一个位子有两种可能，"("和")"
     * 故可以用一颗二叉树来表示所有可能的括号字符串
     * root到每一个叶子的节点连起来表示一个括号字符串
     * 我们这里用1表示左括号，-1表示右括号
     *
     * 符合以下规则的括号字符串才能满足题目需求：
     * 1. 括号字符串从左向右遍历，每一个时刻都必须满足左括号的数量大于等于右括号，即 total>=0
     * 2. 遍历到最后时必须左括号的数量等于右括号的数量，即 total==0
     *
     * @param node 需要生成子二叉树的节点
     */
    public void buildTree(Node node) {
        //规则一：若某一时刻左括号的数量小于右括号，则不用往下继续生成二叉树了
        if (node.total < 0)
            return;

        //规则二：到达结尾时左右括号相等的叶子节点，全部也是正确的括号字符串
        if (node.lev >= Single.lev) {
            //若该节点为最后一层，且root到此节点的和为0，则该节点是一个正确组合的叶子。
            if (node.total == 0) {
                System.out.println(node);
                Single.list.add(node);
            }
            return;
        }

        int newLev = node.lev + 1;
        node.left = new Node(1, newLev, node.total + 1, node);
        buildTree(node.left);
        node.right = new Node(-1, newLev, node.total - 1, node);
        buildTree(node.right);
    }
}

class Node {
    int value;  //该节点的值，1代表"("，-1代表")"，0代表root
    int lev;    //二叉树的层次，root为第0层；对于"()()"，分别对应1-4层
    int total; //从root到该节点（含）的所有节点的值的和
    Node prev;  //父节点
    Node left;  //左孩子
    Node right; //右孩子

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", lev=" + lev +
                ", target=" + total +
                '}';
    }

    public Node(int value, int lev, int target, Node prev) {
        this.value = value;
        this.lev = lev;
        this.total = target;
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

/**
 * 递归函数中需要用到lev（判断递归截止）和list（正确的叶子添加进list保存）
 * 防止递归函数参数过长，制作一个单例类来持有这两个参数
 *
 * 引发问题：本地跑单个测试用例结果正常，但提交leetcode结果错误
 * 分析：leetcode会多线程跑多个测试用例，所以这里不能用单例或者任何静态的东西。
 * 要保证每一个线程的Solution都持有一个自己的list
 */
class Single {
    static int lev;
    static LinkedList<Node> list = new LinkedList<Node>();
}