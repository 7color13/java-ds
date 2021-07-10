package com.atguigu.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges; //存储图对应的邻接矩阵
    private int numOfEdges; //表示边的数目
    private boolean[] isVisited;//定义一个数组，记录某个结点是否被访问

    public static void main(String[] args) {
        int n = 5;//结点的个数
        String vertexValue[] = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环添加顶点
        for (String s : vertexValue) {
            graph.insertVertex(s);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        //显示邻接矩阵
        graph.showGraph();

        System.out.println("深度遍历");
        graph.dfs();
    }

    //构造器
    public Graph(int n){
        //初始化矩阵和vertexList
        edges = new int[n][n];
        isVisited = new boolean[n];
        vertexList = new ArrayList<String>();
        numOfEdges = 0;
    }

    //得到第一个邻接结点的下标w

    /**
     *
     * @param index
     * @return 如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighBor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighBor(int v1, int v2) {
        for (int j=v2+1;j<vertexList.size();j++){
            if (edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }

    //深度优先算法
    public void dfs(boolean[] isVisited,int i){
        //首先访问该结点，输出
        System.out.print(getValueByIndex(i) + "->");
        //将结点设置为已经访问
        isVisited[i]=true;
        //查找结点i的第一个邻接节点w
        int w = getFirstNeighBor(i);
        while (w != -1) {//有邻接结点
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果w结点已经被访问过
            w = getNextNeighBor(i, w);
        }
    }

    //对dfs进行一个重载，遍历我们所有的结点并进行dfs
    public void dfs(){
        //遍历所有的结点进行dfs
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //图中常用的方法
    //返回结点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //返回结点i(下标)对应的数据0->"A" 1->"B"
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph(){
        System.out.println();
        for (int[] edge : edges) {
            System.err.println(Arrays.toString(edge));
        }
    }

    //插入顶点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边
    /**
        * @param v1 表示点的下标即是第几个顶点 "A"-"B" "A"->0 "B"->1
    	* @param v2 表示第二个顶点对应的下标
    	* @param weight 表示关联的值
        * @return void
        * @date 2021-07-10 15:12
    */

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
