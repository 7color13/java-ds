package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = new int[80000];
        for (int i=0;i<80000;i++){
            arr[i] = (int)(Math.random()*8000000);
        }
        bubbleSort(arr);
    }
    public static void bubbleSort(int[] arr){
        int temp = 0 ;
        boolean flag=false; //表示是否进行过交换
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        String date1 = format.format(date);
        System.out.println("排序前:"+date1);
        for (int i=0;i<arr.length-1;i++){
            for (int j = 0 ;j<arr.length-i-1;j++){
                //如果前面的数比后面的大
                if (arr[j]>arr[j+1]){
                    flag = true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }

//            System.out.println("第"+(i+1)+"次排序后的数组");
//            System.out.println(Arrays.toString(arr));
            if (!flag){
                break;
            }else{
                flag=false;
            }
        }
        Date date2 = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        String date3 = format1.format(date2);
        System.out.println("排序前:"+date3);

    }
}
