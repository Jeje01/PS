//DFS

import java.util.Scanner;

public class Main {
    static int[][] arr;
    static boolean visit[];

    public static int dfs(int start){
        int i;
        if(visit[start]==true) return 0;
        visit[start] = true;
        for(i=1; i<arr.length; i++) {
            if(arr[start][i] == 1) dfs(i);
        }
        return 1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i, j, in;
        int[] ans = new int[t];
        for(i=0; i<t; i++){
            int n = sc.nextInt();
            arr = new int[n+1][n+1];
            visit = new boolean[n+1];
            for(j=1; j<n+1; j++) {
                in = sc.nextInt();
                arr[j][in] = 1;
                arr[in][j] = 1;
            }
            for(j=1; j<n+1; j++){
                ans[i] += dfs(j);
            }
        }
        for(i=0; i<t; i++)
            System.out.println(ans[i]);
    }
}
