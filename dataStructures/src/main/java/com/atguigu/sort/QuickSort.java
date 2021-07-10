package com.atguigu.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = new int[8000000];
        for (int i=0;i<8000000;i++){
            arr[i] = (int)(Math.random()*8000000);
        }
        long startTime = System.currentTimeMillis();
        quickSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2]; //中轴值
        int temp =0;//临时变量，交换时使用
        while (l<r){ //比pivot值放到左边，大的放在右边
            while (arr[l]<pivot){
                l+=1;
            }
            while (arr[r]>pivot){
                r-=1;
            }
            //说明pivot左右的值，已经按照左边是小于等于pivot的值，右边全是大于等于Pivot的值
            if (l>=r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换后发现arr[1]==pivot值相等,前移
            if (arr[1]==pivot){
                r-=1;
            }
            //如果交换完后，发现这个arr[r]==pivot值相等l++,后移
            if (arr[r]==pivot){
                l+=1;
            }
        }
        if (l==r){
            l+=1;
            r-=1;
        }

        if (left<r){
            quickSort(arr,left,r);
        }
        if (right>l){
            quickSort(arr,l,right);
        }
    }
}
