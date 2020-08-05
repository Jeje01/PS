//DFS

/* 1

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

*/


// 2 - 200805

/**
 * 섬의 개수
 * DFS
 * 14,764 kb
 * 120 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int w, h, answer;
    static int[][] map;
    static int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    static String line = "";

    public static void dfs(int r, int c) {
        for(int i=0; i<dirs.length; i++) {
            int nr = r+dirs[i][0];
            int nc = c+dirs[i][1];
            if(nr>=0 && nr<map.length && nc>=0 && nc<map[0].length) {
                if(map[nr][nc]==1) {
                    map[nr][nc]=0;
                    dfs(nr, nc);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        while(true) {            
            tokens = new StringTokenizer(input.readLine(), " ");
            h = Integer.parseInt(tokens.nextToken());
            w = Integer.parseInt(tokens.nextToken());
            if(h==0 && w==0)
                break;
            answer = 0;
            map = new int[w][h];
            for(int i=0; i<map.length; i++) {
                tokens = new StringTokenizer(input.readLine(), " ");
                for(int j=0; j<map[0].length; j++) {
                    map[i][j] = Integer.parseInt(tokens.nextToken());
                }
            }
            for(int i=0; i<map.length; i++) {
                for(int j=0; j<map[0].length; j++) {
                    if(map[i][j]==1) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }
            
            output.append(answer).append("\n");
        }
        System.out.println(output.toString());

    }

}

