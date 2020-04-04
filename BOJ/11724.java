//DFS

import java.util.Scanner;

public class Main {
    static int[][] arr;
    static boolean[] visit;
    public static int dfs(int start){
        int i;
        if(visit[start])
            return 0;
        else
            visit[start] = true;
        for(i=1; i<arr.length; i++)
            if(arr[start][i]==1)
                dfs(i);
        return 1;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n+1][n+1];
        visit = new boolean[n+1];
        int i, count=0;
        for(i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            arr[u][v] = 1;
            arr[v][u] = 1;
        }
        for(i=1; i<n+1; i++){
            count+=dfs(i);
        }
        System.out.println(count);
    }
}
