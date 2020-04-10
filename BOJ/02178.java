//BFS - 미로찾기

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[][] arr;
    static int cnt=0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Pos{
        int x, y;

        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(){
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(0, 0));
        int i, nx, ny, x, y;
        while(!q.isEmpty()) {
            Pos newPos= q.poll();
            x = newPos.x;
            y = newPos.y;
            for (i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx>=0 && nx<arr.length && ny>=0 && ny<arr[0].length){
                    if(arr[nx][ny]==1) {
                        arr[nx][ny] = arr[x][y] + 1;
                        q.offer(new Pos(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n][m];
        int i, j;
        for(i=0; i<n; i++){
            String[] s = sc.next().split("");
            for(j=0; j<s.length; j++){
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        bfs();
        System.out.println(arr[n-1][m-1]);
    }
}
