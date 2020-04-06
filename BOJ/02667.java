//DFS

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int[][] arr;
    static int cnt=0;
    static int[][] p = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int dfs(int i, int j){
        int a;
        arr[i][j]=0; cnt++;
        for(a=0; a<p.length; a++){
            int x = i+p[a][0], y = j+p[a][1];
            if(0<=x && x<arr.length && 0<=y && y<arr.length){
                if(arr[x][y]==1){
                    dfs(x, y);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        arr = new int[n][n];
        int i, j;
        for(i=0; i<n; i++){
            String[] sp = sc.next().split("");
            for(j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(sp[j]);
            }
        }
        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                if(arr[i][j]==1){
                    list.add(dfs(i, j));
                    cnt=0;
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(i=0; i<list.size(); i++)
            System.out.println(list.get(i));
    }
}
}
