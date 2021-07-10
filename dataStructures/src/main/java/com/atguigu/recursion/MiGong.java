package com.atguigu.recursion;

public class MiGong {
    public static void main(String[] args) {
        //创建二维数组模拟迷宫
        int[][] map = new int[8][7];
        map[3][1]=1;
        map[3][2]=1;
        //上下全部置为1
        for(int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        for(int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }


        setWay(map,1,1);
        for (int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    //给小球找路
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5]==2){
            return true;
        }else{  //下右上左
            if (map[i][j]==0){  //当前路没有走过
                map[i][j]=2;  //假定该点可以走通
                if (setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if (setWay(map,i-1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else{
                    map[i][j]=3; //走不通
                    return false;
                }

            }else{
                return false; //可能是1，2,3
            }
        }
    }
}
