package com.atguigu.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = {53, 3, 542, 748, 14, 214};
        int arr[] = new int[8000000];
        for (int i=0;i<8000000;i++){
            arr[i] = (int)(Math.random()*8000000);
        }
        long startTime = System.currentTimeMillis();
        radixSort(arr);
//        System.out.println(Arrays.toString(arr));
        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

    //基数排序方法
    public static void radixSort(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();


        //第一轮（针对每个元素的个位进行排序处理
        //定义一个二维数组，表示10个同，每个桶都是一个一位数组，防止溢出，则每个桶数组大小为arr.length
        //空间换时间
        int[][] bucket = new int[10][arr.length];
        //记录每个桶中实际存放了多少数据，记录各个桶每次放入数据的个数
        //bucketElementCounts[0],记录的就是bucket[0]桶放入的数据个数
        int[] bucketElementCounts = new int[10];
        for (int i = 0,n=1; i<maxLength; i++,n*=10) {
            for (int j=0;j<arr.length;j++){
                int digitOfElement = arr[j]/n%10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
            int index = 0 ;
            for (int k=0;k<bucketElementCounts.length;k++){
                //如果桶中有数据，我们才放入到原数组
                if (bucketElementCounts[k]!=0){
                    //循坏该桶即第k个桶
                    for (int l=0;l<bucketElementCounts[k];l++){
                        arr[index++] = bucket[k][l];
                    }
                }
                //第一轮处理后，需要清零
                bucketElementCounts[k] = 0;
            }
        }

    }
}
