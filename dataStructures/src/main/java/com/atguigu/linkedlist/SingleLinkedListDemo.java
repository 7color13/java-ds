package com.atguigu.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.list();
//        hero3 = new HeroNode(3, "垃圾", "智多星");
//        singleLinkedList.update(hero3);
//        System.out.println("修改后");
//        singleLinkedList.list();
//        System.out.println(singleLinkedList.trueCount());
//        singleLinkedList.delete(hero3);
//        System.out.println("删除后");
//        singleLinkedList.list();
//        System.out.println(singleLinkedList.trueCount());
//
//
//        singleLinkedList.backList();
//        System.out.println("反转后");
//        singleLinkedList.list();
        HeroNode hero5 = new HeroNode(5, "宋江", "及时雨");
        HeroNode hero6 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode hero7 = new HeroNode(6, "吴用", "智多星");
        HeroNode hero8 = new HeroNode(8, "林冲", "豹子头");
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.addByOrder(hero5);
        singleLinkedList1.addByOrder(hero6);
        singleLinkedList1.addByOrder(hero7);
        singleLinkedList1.addByOrder(hero8);
        singleLinkedList1.list();

        HeroNode heroNode = singleLinkedList.mergeList(singleLinkedList, singleLinkedList1);
        singleLinkedList.list();
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                temp = temp.next;
            }
        }
        //退出while循环时temp指向链表最后
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false; //标志添加的标号是否存在
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {  //位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("准备插入的编号已存在" + heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.next.no == newHeroNode.no) {
                newHeroNode.next = temp.next.next;
                temp.next = newHeroNode;
                break;
            }
            temp = temp.next;
        }
    }

    public void delete(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.next == null) {
                head.next = heroNode;
                break;
            } else if (temp.next.no == heroNode.no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    //链表有效节点个数
    public int trueCount() {
        if (head.next == null) {
            return 0;
        }
        HeroNode temp = head.next;
        int count = 1;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void backList() {
        if (head.next == null || head.next.next == null) {
            return;
        } else {
            HeroNode reverseNodeHead = new HeroNode();
            HeroNode cur = head.next;
            HeroNode next = new HeroNode();
            HeroNode temp = head;
            while (cur!=null){
               next = cur.next;
               cur.next = reverseNodeHead.next;
               reverseNodeHead.next = cur;
               cur =next;
            }
            head.next=reverseNodeHead.next;
        }

    }

    public HeroNode mergeList(SingleLinkedList list1,SingleLinkedList list2){
        HeroNode head1 = new HeroNode();
        HeroNode head2 = new HeroNode();
        HeroNode head3 = new HeroNode();
        HeroNode temp1 = head1.next;
        HeroNode temp2 = head2.next;
        HeroNode temp3 = head2.next;
        SingleLinkedList list3 = new SingleLinkedList();
      while(temp1!=null||temp2!=null){
          if (temp1.no>temp2.no){
              temp3.next=temp2.next;
              temp2=temp2.next;
          }else{
              temp3.next=temp1.next;
              temp1 = temp1.next;
          }
          temp3=temp3.next;
      }
        head.next = head3.next;
     return head;
    }

    //显示链表（遍历）
    public void list() {
        if (head.next == null) {
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int hNo, String hName, String nickname) {
        this.no = hNo;
        this.name = hName;
        this.nickname = nickname;
    }

    public HeroNode() {
     super();
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '\'' + '}';
    }
}
