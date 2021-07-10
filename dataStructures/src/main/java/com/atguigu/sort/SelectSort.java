package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        int arr[] = new int[80000];
        for (int i=0;i<80000;i++){
            arr[i] = (int)(Math.random()*8000000);
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        String date1 = format.format(date);
        System.out.println("排序前:"+date1);
        selectSort(arr);
        Date date2 = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        String date3 = format1.format(date2);
        System.out.println("排序前:"+date3);
    }

    public static void selectSort(int[] arr){
        for (int i = 0;i<arr.length-1;i++){
            int minIndex = i;
            int min = arr[i];
            for (int j=1+i;j<arr.length;j++){
                if (min>arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            //将最小值放在arr[0],即交换
            if (minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }


        }
        }
        //使用逐步推导

}
