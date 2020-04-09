//BFS - 토마토

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[][] arr;
    static int[][] c = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static class Pos {
        int x, y;

        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(int n, int m){
        int i, j, max=0, check=0;
        Queue<Pos> q = new LinkedList<>();
        //1인 토마토 offer
        for(i=0; i<n; i++){
            for(j=0; j<m; j++){
                if(arr[i][j]==1){
                    q.offer(new Pos(i, j));
                    check++;
                }
                else if(arr[i][j]==0) check++;
            }
        }
        if(check==0) return 0;
        while(!q.isEmpty()){
            Pos pos = q.poll();
            int x = pos.x;
            int y = pos.y;
            //상하좌우 삽입
            for(i=0; i<4; i++){
                int nx = x+c[i][0];
                int ny = y+c[i][1];
                if(nx>=0 && nx<arr.length && ny>=0 && ny<arr[0].length){
                    if(arr[nx][ny]==0){
                        q.offer(new Pos(nx, ny));
                        arr[nx][ny]=arr[x][y]+1;
                    }
                }
            }
        }
        for(i=0; i<arr.length; i++){
            for(j=0; j<arr[0].length; j++){
                if(arr[i][j]==0) return -1;
                max = arr[i][j] > max ? arr[i][j] : max;
            }
        }
        return max-1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int answer = 0;
        arr = new int[n][m];
        int i, j, cnt=0;
        for(i=0; i<n; i++){
            for(j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        answer = bfs(n, m);
        System.out.println(answer);

    }
}
