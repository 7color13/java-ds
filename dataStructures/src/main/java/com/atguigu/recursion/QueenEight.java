package com.atguigu.recursion;

public class QueenEight {
    //定义一个max表示有多少皇后
    int max = 8;
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        QueenEight queenEight = new QueenEight();
        queenEight.check(0);
        System.out.println("一共有"+count+"种解法");
    }

    //放置第n个皇后
    private void check(int n){
        if (n == max){
            print();
            return;
        }
        //依次放入皇后并判断是否冲突

        //特别注意：check是每一次递归时都有for循环，因此会有回溯
        for (int i=0;i<max;i++){
            //先把当前皇后n,放到改行的第一列
            array[n] = i;
            //判断当放置到i列时是否冲突
            if (judge(n)){ //不冲突，接着放n+1个皇后
                check(n+1);  //回溯
            }
            //如果冲突继续执行array[n] = i;即将第n个皇放置在本行的后移的位置
        }
    }


    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放皇后是否和已经摆放的皇后冲突
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //判断第n个皇后是否和前面n-1个皇后是否在同一列
            //判断第n个皇后是否和前面n-1个皇后在同一斜线
            if (array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    //姜皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
