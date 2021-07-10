package com.atguigu.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取数据");
            System.out.println("h(head):查看队列头数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = arrayQueue.getQueue();
                        System.out.println(res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println("头数据是"+res);
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}


//使用数组模拟数列
class ArrayQueue{
    private int maxSize;  //数组最大容量
    private int front;  //队列头
    private int rear;  // 队列尾
    private int[] arr;  //该数据用于存放数据，模拟队列

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;  //指向队列的头部，队列头的前一个位置
        rear = -1 ; //指向队列尾（队列最后一个数据）
    }

    public boolean isFull(){
        return rear == maxSize-1;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满");
            return;
        }else{
            rear++;
            arr[rear] = n;
        }
    }

    //出队列，取数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i=0;i<arr.length;i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列是空的");
        }
        return arr[front+1];
    }
}
