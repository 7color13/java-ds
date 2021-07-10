package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        int arr[] = new int[8000000];
        for (int i=0;i<8000000;i++){
            arr[i] = (int)(Math.random()*8000000);
        }
        long startTime = System.currentTimeMillis();
        shellSort2(arr);

        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

    public static void shellSort(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 5; i < arr.length; i++) {
                //遍历各族中所有元素（共5组，每组两个元素，步长5
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//          System.out.println("第x轮后=" + Arrays.toString(arr));
        }
        //因为第一轮排序，10个数据分成5组


    }
    public static void shellSort2(int[] arr){
        int temp =0;
        for (int gap = arr.length/2;gap>0;gap/=2){
            for (int i=gap;i<arr.length;i++){
                int  j = i;
                 temp = arr[j];
                if (arr[j]<arr[j-gap]){
                    while(j-gap>=0&&temp<arr[j-gap]){
                        //移动
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    //退出while，gap找到位置
                    arr[j] = temp;
                }
            }
        }
    }
}
