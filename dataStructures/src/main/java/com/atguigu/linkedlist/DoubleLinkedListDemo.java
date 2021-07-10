package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
//        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
//        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
//        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
//        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
//        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);
//        doubleLinkedList.list();

        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.list();
//
//        HeroNode2 heroNode2 = new HeroNode2(4, "公孙胜", "入云龙");
//        doubleLinkedList.update(heroNode2);
//        System.out.println("修改后的链表情况");
//        doubleLinkedList.list();
//
//        doubleLinkedList.delete(3);
//        System.out.println("删除后的链表情况");
//        doubleLinkedList.list();
    }
}

//创建双向链表的类
class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                temp = temp.next;
            }
        }
        //退出while循环时temp指向链表最后
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void addByOrder(HeroNode2 heroNode2){
        HeroNode2 temp = head;
        while (true){
            if (temp.next==null){
               break;
            }else if(temp.next.no>heroNode2.no){
             break;
            }
            temp=temp.next;
        }
        HeroNode2 nextNode = temp.next;
        temp.next = heroNode2;
        heroNode2.next = nextNode;
        if (nextNode!=null){
            nextNode.pre = heroNode2;
        }
        heroNode2.pre = temp;
    }


    //双向链表的修改和单向链表修改几乎一样
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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

    //从双向链表中删除一个节点
    //说明：对于双向链表我们可以直接找到要删除的节点，找到后直接自我删除
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.printf("要删除的节点不存在");
                break;
            } else if (temp.no == no) {
                temp.next.pre = temp.pre;
                if (temp.next != null) {
                    temp.pre.next = temp.next;
                }

                break;
            }
            temp = temp.next;
        }
    }

    //遍历双向链表
    public void list() {
        if (head.next == null) {
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int hNo, String hName, String nickname) {
        this.no = hNo;
        this.name = hName;
        this.nickname = nickname;
    }

    public HeroNode2() {
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

