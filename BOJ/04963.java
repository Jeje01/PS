//DFS

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int[][] arr;
    static int cnt;
    static int[][] c = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public static int dfs(int a, int b){
        int i;
        arr[a][b]=0;
        for(i=0; i< c.length; i++){
            int x = a + c[i][0];
            int y = b + c[i][1];
            if(x>=0 && x<arr.length && y>=0 && y<arr[0].length){
                if(arr[x][y] == 1) {
                    dfs(x, y);
                }
            }
        }
        return 1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int i, j;
        while(true){
            int b = sc.nextInt();
            int a = sc.nextInt();
            cnt=0;
            if(a==0 && b==0) break;
            arr= new int[a][b];
            for(i=0; i<a; i++){
                for(j=0; j<b; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            for(i=0; i<a; i++){
                for(j=0; j<b; j++){
                    if(arr[i][j]==1) {
                        cnt += dfs(i, j);
                    }
                }
            }
            list.add(cnt);
        }
        for(i=0; i<list.size(); i++)
            System.out.println(list.get(i));
    }
}
