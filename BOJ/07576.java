//BFS - 토마토

//1

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


// 2 - 200805

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int M, N, answer, count, max;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<int[]> queue = new LinkedList<>();
    
    static void bfs() {
        while(!queue.isEmpty()) {
            int[] next = queue.poll();
            count++;
            max = next[2]>max? next[2]: max;
            for(int i=0; i<4; i++) {
                int nr = next[0]+dirs[i][0];
                int nc = next[1]+dirs[i][1];
                if((nr>=0 && nr<N && nc>=0 && nc<M) && map[nr][nc]==0) {
                    queue.offer(new int[] {nr, nc, next[2]+1});
                    map[nr][nc]=1;
                    visited[nr][nc] = true;
                    
                }
            }
        }
        return ;
    }
    
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine(), " ");
        M = Integer.parseInt(tokens.nextToken());
        N = Integer.parseInt(tokens.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            tokens = new StringTokenizer(input.readLine(), " ");
            for(int j=0; j<M; j++)
                map[i][j] = Integer.parseInt(tokens.nextToken());
        }
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j]==-1) count++;
                if(!visited[i][j] && map[i][j]==1) {
                    queue.offer(new int[] {i, j, 0});
                }
            }
        }
        bfs();
        
        if(count!=M*N)
            answer = -1;
        else {
            answer = max;
        }
        output.append(answer);
        System.out.println(output.toString());
    }

}
