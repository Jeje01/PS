// BFS - 네트워크

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int i, cnt=0;
        for(int j=0; j<n; j++){
            if(visited[j]==false){
                q.offer(j); cnt++;
                while(!q.isEmpty()){
                    int p = q.poll();
                    visited[p] = true;
                    for(i=0; i<n; i++){
                        if(i==p || visited[i]==true) continue;
                        if(computers[p][i]==1){
                            q.offer(i);
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
