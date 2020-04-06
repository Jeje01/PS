//DFS

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int[][] arr;
    static int cnt=0;
    public static int dfs(int i, int j){
        arr[i][j]=0; cnt++;
        if(0<=i+1 && i+1<arr.length)
            if(arr[i+1][j]==1){//↓
                dfs(i+1, j);
            }
        if(0<=j+1 && j+1<arr.length)
            if(arr[i][j+1]==1){//→
                dfs(i, j+1);
            }
        if(0<=i-1 && i-1<arr.length)
            if(arr[i-1][j]==1){//↑
                dfs(i-1, j);
            }
        if(0<=j-1 && j-1<arr.length)
            if(arr[i][j-1]==1){//←
                dfs(i, j-1);
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
        int[] answer = new int[list.size()];
        for(i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        System.out.println(list.size());
        for(i=0; i<answer.length; i++)
            System.out.println(answer[i]);
    }
}
