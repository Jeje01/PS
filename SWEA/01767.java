/**
 * 프로세서 연결하기
 * 완전탐색
 * 35,228 kb
 * 163 ms
 * 
 * 효율적인 방법이 있을까 했지만 다 해보는 거였다
 * 전부 탐색해보며 가지치기를 적절하게 해야 시간을 줄일 수 있다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int T, N, answer, maxCores;
    static int[] answers;
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 하, 상, 우, 좌
    static List<Pos> list = new ArrayList<>();
     
    static class Pos{
        int r;
        int c;
         
        public Pos(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
         
    }
     
    static void dfs(boolean[][] visited, int cnt, int idx, int cores) {
        if(cnt>=answers[list.size()]) return;
        if(list.size()-idx+cores<maxCores) return;
        if(idx==list.size()) {
            answers[cores] = Math.min(answers[cores], cnt);
            maxCores = Math.max(maxCores, cores);
            return;
        }
        Pos tmp = list.get(idx);
        for(int i=0; i<4; i++) {
            int tmpR = tmp.r;
            int tmpC = tmp.c;
            int tmpCnt = cnt;
            boolean[][] tmpV = new boolean[N][N];
            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    tmpV[j][k] = visited[j][k];
                }
            }
            // 벽까지 검사 - 선이나 core이 있는지 -> 있으면 continue
            boolean goEnd = true;
            while(true) {
                int nr = tmpR+dirs[i][0];
                int nc = tmpC+dirs[i][1];
                if(nr<0 || nr>=N || nc<0 || nc>=N) {
                    break;
                }
                if(tmpV[nr][nc]) {
                    goEnd = false;
                    break;
                }
                tmpV[nr][nc] = true;
                tmpCnt++;
                tmpR = nr;
                tmpC = nc;
            }
            if(!goEnd) continue;
            // dfs
            dfs(tmpV, tmpCnt, idx+1, cores+1);
 
        }
        boolean[][] tmpV = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                tmpV[i][j] = visited[i][j];
            }
        }
        dfs(tmpV, cnt, idx+1, cores);
         
         
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        T = Integer.parseInt(input.readLine().trim());
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(input.readLine().trim());
            boolean[][] map = new boolean[N][N];
            list.clear();
            answer = Integer.MAX_VALUE;
            maxCores = 0;
            for(int i=0; i<N; i++) {
                tokens = new StringTokenizer(input.readLine(), " ");
                for(int j=0; j<N; j++) {
                    map[i][j] = tokens.nextToken().equals("0")? false: true;
                    if(i==0 || j==0 || i==N-1 || j==N-1) continue;
                    if(map[i][j]) {
                        list.add(new Pos(i, j));
                    }
                }
            }
            answers = new int[list.size()+1];
            Arrays.fill(answers, Integer.MAX_VALUE);
            dfs(map, 0, 0, 0);
             
            for(int i=answers.length-1; i>=0; i--) {
                if(answers[i]!=Integer.MAX_VALUE) {
                    answer = answers[i];
                    break;
                }
            }
         
            output.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(output.toString());
    }
 
}
