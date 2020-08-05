//DFS
/* 1
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
*/


// 2 - 200805
/**
 * 단지번호로붙이기
 * DFS
 * 13,068 kb
 * 80 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int[][] map;
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int N, houses, cnt;
    static String line = "";
    static ArrayList<Integer> list = new ArrayList<>();

    public static void dfs(int r, int c) {
        map[r][c]=0;
        houses++;
        for(int i=0; i<dirs.length; i++) {
            int nr = r+dirs[i][0];
            int nc = c+dirs[i][1];
            if((nr>=0 && nr<N && nc>=0 && nc<N)&& map[nr][nc]==1) {
               dfs(nr, nc);

            }
        }
        return;
        
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(input.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            line = input.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]==1) {
                    houses=0;
                    dfs(i, j);
                    cnt++;
                    list.add(houses);
                }
            }
        }
        Collections.sort(list);
        output.append(cnt).append("\n");
        for(int i=0; i<list.size(); i++) {
            output.append(list.get(i)).append("\n");
        }
        System.out.println(output.toString());
        

    }

}


