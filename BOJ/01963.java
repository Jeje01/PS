import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] notPrime = new boolean[10000];

    public static int checkNum(int num, int i, int j){
        int changed = 0;
        switch(i){
            case 0:
                changed = num%1000+j*1000;
                break;
            case 1:
                changed = num/1000*1000 + num%100 + j*100;
                break;
            case 2:
                changed = num/100*100 + num%10 + j*10;
                break;
            case 3:
                changed = num/10*10 + j;
                break;
        }
        return changed;
    }

    public static int bfs(int start, int end){
        boolean[] visited = new boolean[10000];
        Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[]{start, 0});
        int i, j;
        while(!q.isEmpty()){
            int num = q.peek()[0];
            int cnt = q.peek()[1];
            if(num==end) return cnt;
            q.poll();
            if(visited[num]==true) continue;
            visited[num] = true;
            for(i=0; i<4; i++){
                for(j=0; j<10; j++){
                    if(i==0 && j==0) continue;
                    int tmp = checkNum(num, i, j);
                    if(notPrime[tmp] == false && visited[tmp] == false) {
                        q.offer(new Integer[]{tmp, cnt+1});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int i, j;
        int[] ans = new int[t];
        for(i=2; i<notPrime.length; i++){
            if(notPrime[i]!=true) {
                for (j = 2; i*j < notPrime.length; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        for(i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(start == end) ans[i] = 0;
            else{
                ans[i] = bfs(start, end);
            }
        }
        for(i=0; i<t; i++) {
            if(ans[i]==-1)
                System.out.println("Impossible");
            else
                System.out.println(ans[i]);
        }
    }
}
