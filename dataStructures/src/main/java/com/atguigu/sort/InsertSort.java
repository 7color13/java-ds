package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
        int arr[] = new int[800000];
        for (int i=0;i<800000;i++){
            arr[i] = (int)(Math.random()*8000000);
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        String date1 = format.format(date);
        System.out.println("排序前:"+date1);
        insertSort(arr);
        Date date2 = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        String date3 = format1.format(date2);
        System.out.println("排序前:"+date3);
    }

    public static void insertSort(int[] arr){

        for (int i=1;i<arr.length;i++){
            int insertVal = arr[i];
            int insertIndex = i-1; //前面数的下标
            //insertVal插入的位置
            while (insertIndex>=0&&insertVal<arr[insertIndex]){  //找插入位置时不越界,待插入数还没找到适当位置
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置已找到，insertIndex
            arr[insertIndex+1] = insertVal;
//            System.out.println("第"+i+"轮后的数组："+ Arrays.toString(arr));
        }
        //定义待插入的数

    }
}
