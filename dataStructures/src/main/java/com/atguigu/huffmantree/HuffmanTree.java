package com.atguigu.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        preOrder(root);
    }

    public static void preOrder( Node root){
        if (root!=null){
            root.preOrder();
        }else{
            System.out.println("是空树，无法遍历");
        }
    }

    //创建赫夫曼树的方法
    public static Node createHuffmanTree(int[] arr) {
        //第一步为了操作方便
        //1.遍历arr数组，将arr每个元素构成一个node,将node放入到ArrayList中
        List<Node> nodes = new ArrayList<Node>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        //循环过程
        while (nodes.size() > 1) {
            //排序从小到大
            Collections.sort(nodes);

            //取出根节点权值最小的两颗二叉树
            //(1)取出权值最小的二叉树
            Node leftNode = nodes.get(0);
            //(2)取出第二小的结点
            Node rightNode = nodes.get(1);
            //(3)构建一个新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //(4)从arrayList中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5)将parent加入到nodes
            nodes.add(parent);
        }
        //返回赫夫曼树的root结点
        return nodes.get(0);

    }
}

//为了让node这个对象持行排序Collections集合排序
class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;


    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;//从小到大排序
    }
}
