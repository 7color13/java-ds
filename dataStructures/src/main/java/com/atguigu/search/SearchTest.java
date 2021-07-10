package com.atguigu.search;

public class SearchTest {
    public static void main(String[] args) {
        int arr[] = {1,3,9,24,33};
        int index = binarySearch(arr, 0,arr.length-1,33);
        System.out.println(index);
    }

    /**
     * 2021-07-09
     * @param arr
     * @param value
     * @return
     */
    //顺序查找
    public static int seqSearch(int[] arr,int value){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==value){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr,int left,int right,int value) {

        int l = left;
        int r = right;
        if (l>r){
            return -1;
        }
        int mid = (l+r)/2;
        if ( arr[mid]==value){
           return mid;
        }
        else if (arr[mid]>value){
            return binarySearch(arr,l,mid-1,value);
        }
        else{
            return binarySearch(arr,mid+1,r,value);
        }
    }
}
