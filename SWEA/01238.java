/**
 * Contract
 * BFS
 * 17,432 kb
 * 107 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int[][] map;
    static int len, start, t, answer, maxLevel;
    static Queue<int[]> queue = new LinkedList<int[]>(); 
    static boolean[] visited;
    static ArrayList<int[]> list;
     
    public static void bfs(int startPoint, int cnt) {
        queue.offer(new int[] {startPoint, 0});
        visited[startPoint] = true;
        while(!queue.isEmpty()) {
            int[] next = queue.poll();
            list.add(next);
            for(int i=1; i<map.length; i++) {
                if(map[next[0]][i]==1 && !visited[i]) {
                    queue.offer(new int[] {i, next[1]+1});
                    visited[i] = true;
                }
            }
        }
        return;
    }
    public static void main(String[] args) throws IOException {
        String line ="";
        int tmp=0;
        while((line = input.readLine())!=null) {
            t++;
            answer = maxLevel = 0;
            map = new int[101][101];
            visited = new boolean[101];
            list = new ArrayList<int[]>();
            tokens = new StringTokenizer(line, " ");
            len = Integer.parseInt(tokens.nextToken());
            start = Integer.parseInt(tokens.nextToken());
            tokens = new StringTokenizer(input.readLine(), " ");
            for(int i=0; i<len/2; i++) {
                    int r = Integer.parseInt(tokens.nextToken());
                    int c = Integer.parseInt(tokens.nextToken());
                    map[r][c]=1;
            }
            bfs(start, 0);
             
            for(int i=0; i<list.size(); i++) {
                int[] his = list.get(i);
                if(his[1]>maxLevel) {
                    answer = his[0];
                    maxLevel = his[1];
                }else if(his[1]==maxLevel) {
                    answer = answer>his[0]? answer: his[0];
                }
            }
                 
            output.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(output.toString());
        }
 
}
