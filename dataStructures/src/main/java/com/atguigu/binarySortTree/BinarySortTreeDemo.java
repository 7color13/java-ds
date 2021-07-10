package com.atguigu.binarySortTree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1,0};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历二叉排序树");
        binarySortTree.infixOrder();

        binarySortTree.delNode(1);
        System.out.println("删除结点后");
        binarySortTree.infixOrder();
    }
}


//创建二叉排序树
class BinarySortTree {
    private Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空");
        }
    }

    //查找要删除的结点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找要删除的结点的父结点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 编写方法：
     * 1. 返回的以node传入的结点（当做二叉排序树的根结点
     * 2. 删除node为根结点的二叉排序树的最小结点
     *
        * @param node 传入的结点（当做二叉排序树的根结点）
        * @return int  返回的以node为根结点的二叉排序树的最小结点的值
        * @date 2021-07-10 11:18
    */
    
    public int delRightTreeMin(Node node){
        Node target = node;
        //循环的查找左结点，就会找到最小值
        while (target.left!=null){
            target = target.left;
        }
        //这时target就指向了最小结点
        delNode(target.value);//删除最小结点
        return target.value;
    }

    public int delLeftTreeMax(Node node){
        Node target = node;
        //循环的查找右结点，就会找到最大值
        while (target.right!=null){
            target = target.right;
        }
        //这时target就指向了最小结点
        delNode(target.value);//删除最小结点
        return target.value;
    }

    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //先找到删除结点 targetNode
            Node targetNode = search(value);
            //如果没有找到要删除的结点
            if (targetNode == null) {
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个结点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //去找到targetNode的父结点
            Node parent = searchParent(value);
            //如果要删除的结点是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                //判断targetNode是父结点的左子结点还是右子结点
                if (parent.left != null && parent.left == targetNode) { //是左子结点
                    parent.left = null;
                } else if (parent.right != null && parent.right == targetNode) {
                    parent.right = null;
                }
            }else if (targetNode.left!=null&&targetNode.right!=null){ //删除有两颗子树的结点
//              int minValue = delRightTreeMin(targetNode.right);
//                targetNode.value = minValue;
                int maxValue = delLeftTreeMax(targetNode.left);
                targetNode.value = maxValue;
            }else{  //删除只有一颗子树的结点
                //如果要删除的结点有左子结点
                if (targetNode.left!=null){
                    if (parent!=null){
                        //如果targetNode是parent的左子结点
                        if (parent.left.value == value){
                            parent.left = targetNode.left;
                        }else{  //targetNode是parent的右子结点
                            parent.right = targetNode.left;
                        }
                    }else{
                        root = targetNode.left;
                    }
                }else{ //要删除的结点右子结点
                    if (parent!=null){
                        //如果targetNode是parent的左子结点
                        if (parent.left.value==value){
                            parent.left = targetNode.right;
                        }else{  //如果targetNode是parent是parent的右子结点
                            parent.right = targetNode.right;
                        }
                    }else{
                        root = targetNode.right;
                    }

                }
            }

        }
    }
}

//创建node结点
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * @param value 查找删除的结点的值
     * @return com.atguigu.binarySortTree.Node 如果找到返回该节点，否则返回null
     * @date 2021-07-10 10:13
     */

    public Node search(int value) {
        if (value == this.value) {  //找到就是该结点
            return this;
        } else if (value < this.value) {  //应该向左子树递归查找
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);  //找不到直接return null
        } else {   //右子树递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找要删除结点的父节点

    /**
     * @param value 要找到的结点的值
     * @return com.atguigu.binarySortTree.Node  要删除的结点的父节点，如果没有则返回null
     * @date 2021-07-10 10:21
     */

    public Node searchParent(int value) {
        //如果当前结点就是当前要删除的结点的父节点
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的这个值小于当前结点的值，并且当且当前结点的左子结点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);//向左子树递归查找
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);//向右子树递归查找
            } else {
                return null;//没有找到父节点
            }
        }
    }


    //添加结点的方法
    //递归形式添加结点，注意满足二叉排序树的要求
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断传入结点的值和当前 根结点的值关系
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        }
        if (node.value >= this.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
