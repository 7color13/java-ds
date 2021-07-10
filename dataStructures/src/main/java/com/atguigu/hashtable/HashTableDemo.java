package com.atguigu.hashtable;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        //菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add：添加雇员");
            System.out.println("list：显示雇员");
            System.out.println("find：查找雇员");
            System.out.println("exit：退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入你要查找的id");
                     id = scanner.nextInt();
                     hashTab.findEmpById(id);
                     break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}

//创建hashTable管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;  //表示共有多少条链表

    public HashTab(int size) {
        this.size = size;
        //初始化empLinkedListArray
        empLinkedListArray = new EmpLinkedList[size];
        //初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工的id,得到该员工应该添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    //根据输入的id查找雇员
    public void findEmpById(int id){
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if (emp!=null){
            System.out.printf("在第%d条链表中找到雇员id=%d\n",(empLinkedListNO+1),id);
        }else{
            System.out.println("在哈希表中没有找到该雇员");
        }
    }

    //遍历所有的链表，遍历hash表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //编写一个散列函数，取模法
    public int hashFun(int id) {
        return id % size;
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//创建EmpLinkedList表示链表
class EmpLinkedList {
    //头指针，执行第一个temp,因此我们这个链表的head是直接指向第一个Emp
    private Emp head; //默认null

    //添加雇员到链表
    //说明
    //1.假定，当添加雇员时，id是自增长，即id分配是从小到大
    //因此我们直接将雇员直接加入到本链表最后即可
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;//后移
        }
        //退出时，直接将emp链表
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(int no) {
        if (head == null) { //链表为空
            System.out.println("第"+(no+1)+"链表为空");
            return;
        }
        System.out.print("第"+(no+1)+"条链表的信息为");
        Emp cueEmp = head;
        while (true) {
            System.out.printf("=>id=%d name=%s\t", cueEmp.id, cueEmp.name);
            if (cueEmp.next == null) { //已经是最后节点
                break;
            }
            cueEmp = cueEmp.next; //后移，遍历
        }
        System.out.println();
    }

    //根据id查找雇员
    public Emp findEmpById(int id){
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id==id){
                break;
            }
            if (curEmp.next==null){
                curEmp=null;
                break;
            }
            curEmp=curEmp.next;
        }
        return curEmp;
    }
}
