//DFS, BFS

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void dfs(int[][] arr, int v, int init){
        int i, j;
        System.out.print(v+" ");
        for(i=1; i<arr.length; i++){
            if(arr[v][i] ==1 && i!= init){
                arr[i][v]=0;
                for(j=1; j<arr.length; j++)
                    arr[j][i]=0;
                dfs(arr, i, init);
            }
        }
    }
    public static void bfs(int[][] arr, int v, int init){
        Queue<Integer> q = new LinkedList<>();
        int i, j, tmp;
        q.offer(v);
        while(!q.isEmpty()){
            tmp = q.poll();
            System.out.print(tmp);
            for(i=1; i<arr.length; i++){
                if(arr[tmp][i] == 1){
                    q.offer(i);
                    arr[i][tmp]=0;
                    for(j=1; j<arr.length; j++)
                        arr[j][i]=0;
                }
            }
            if(!q.isEmpty()) System.out.print(" ");

        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        int[][] tmp = new int[n+1][n+1];
        for(i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
            tmp[a][b] = 1;
            tmp[b][a] = 1;
        }
        dfs(arr, v, v);
        System.out.println();
        bfs(tmp, v, v);
    }
}
