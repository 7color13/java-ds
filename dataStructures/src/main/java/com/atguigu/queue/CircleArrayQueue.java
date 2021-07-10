package com.atguigu.queue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        System.out.println("测试环形队列");
        ArrayCircle arrayQueue = new ArrayCircle(4);
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

class ArrayCircle{
    private int maxSize;  //数组最大容量
    private int front;  //队列头
    private int rear;  // 队列尾
    private int[] arr;  //该数据用于存放数据，模拟队列

    public ArrayCircle(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;  //队列的第一个元素
        rear = 0; //队列尾
    }

    public boolean isFull(){
        return (rear+1)%maxSize == front;
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
            arr[rear] = n;
            rear = (rear+1)%maxSize;
        }
    }

    //出队列，取数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        int value  = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i=front;i<front+size();i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    //求出当前数列有效数据
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //显示头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列是空的");
        }
        return arr[front];
    }
}

