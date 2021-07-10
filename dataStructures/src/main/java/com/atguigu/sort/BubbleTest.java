package com.atguigu.sort;

import java.util.Arrays;

public class BubbleTest {
    public static void main(String[] args) {
        int[] arr = {3,1,2,7,4};
        quickSortTest2(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleTest(int[] arr){
        boolean flag =false;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp =arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
            if (!flag){
                break;
            }else{
                flag=false;
            }
        }
    }

    public static void selectSort(int[] arr){

        for (int i=0;i<arr.length-1;i++){
            int min = arr[i];
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<min){
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (minIndex!=i){

                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }

    }

    public static void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
           int insertVal = arr[i];
           int insertIndex = i-1;
           while (insertIndex>=0&&insertVal<arr[insertIndex]){
               arr[insertIndex+1] = arr[insertIndex];
               insertIndex--;
           }
           arr[insertIndex+1] = insertVal;
        }
    }


    //2021-07-08
    public static void bubbleTest2(int[] arr){
        int temp = 0;
        boolean flag = false;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j+1]<arr[j]){
                    temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }else{
                flag=false;
            }
        }
    }

    public static void selectSort2(int[] arr){

        for (int i=0;i<arr.length-1;i++){
            int min = arr[i];
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }
    }

    public static void insertSortTest(int[] arr){

        for (int i=1;i<arr.length;i++){
            int insertIndex = i-1;
            int insertValue = arr[i];
            while (insertIndex>=0&&insertValue<arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertValue;
        }
    }

    public static void quickSortTest1(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2]; //中轴值
        int temp =0;//临时变量，交换时使用
        while (l<r){
            while (arr[l]<pivot){
                l+=1;
            }
            while (arr[r]>pivot){
                r-=1;
            }
            if (l>=r){
                break;
            }
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
            quickSortTest1(arr,left,r);
        }
        if (right>l){
            quickSortTest1(arr,l,right);
        }
    }


    //2021-07-09
    public static void quickSortTest2(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int temp = 0;
        int pivot = arr[(left+right)/2];
        while (l<r){
            while (arr[l]<pivot){
                l+=1;
            }
            while (arr[r]>pivot){
                r-=1;
            }
            if (l>=r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l]==pivot){
                r-=1;
            }
            if (arr[r] == pivot){
                l+=1;
            }

        }
        if (l==r){
            l+=1;
            r-=1;
        }
        if (left<r){
            quickSortTest2(arr,left,r);
        }
        if (right>l){
            quickSortTest2(arr,l,right);
        }
    }

}
