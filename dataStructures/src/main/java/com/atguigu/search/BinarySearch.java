package com.atguigu.search;


import java.util.ArrayList;

//使用二分查找的前提是该数组是有序的
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,0,89,1000,1000,1234};
        ArrayList<Integer> list = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(list);
    }

    /**
     * 二分查找算法
     * @param arr 数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findVal 如果找到就返回下标，如果没有找到，就返回-1
     */
    public static int  binarySearch(int[] arr,int left,int right,int findVal){
        //当left>right时说明递归完毕，但是没有找到
        if (left>right){
            return -1;
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if (findVal>midVal){  //向右递归
            return binarySearch(arr,mid+1,right,findVal);
        }else if(findVal<midVal){  //向左递归
            return binarySearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }
    }
    
    /**
        * @param arr
    	* @param left
    	* @param right
    	* @param findVal
        * @return java.util.ArrayList<java.lang.Integer>
        * @date 2021-07-09 10:58
    */
    

    //思路分析，在找到mid值不要马上返回，先向mid索引的左边扫描，将所有满足1000的下标加入到集合中
    public static ArrayList<Integer>  binarySearch2(int[] arr,int left,int right,int findVal){
        //当left>right时说明递归完毕，但是没有找到
        if (left>right){
            return new ArrayList<>();
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if (findVal>midVal){  //向右递归
            return binarySearch2(arr,mid+1,right,findVal);
        }else if(findVal<midVal){  //向左递归
            return binarySearch2(arr,left,mid-1,findVal);
        }else{
            ArrayList<Integer> resIndexList = new ArrayList<Integer>();
            int temp = mid-1;
            while (true){
                if (temp<0||arr[temp]!=findVal){
                    break;
                }
                //否则就把temp放入集合
                resIndexList.add(temp);
                temp-=1;
            }
            resIndexList.add(mid);
            temp = mid+1;
            while (true){  //右边扫描
                if (temp>arr.length+1||arr[temp]!=findVal){
                    break;
                }
                //否则就把temp放入集合
                resIndexList.add(temp);
                temp+=1; //temp右移
            }
            return resIndexList;
        }
    }
}
