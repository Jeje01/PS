// BFS - 스타트링크

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int i;
        for(i=0; i<5; i++){
            if(i!=4)
                arr[i] = sc.nextInt();
            else
                arr[i] = -sc.nextInt();
        }
        Queue<Integer[]> q = new LinkedList<>();
        HashMap<Integer, Integer> h = new HashMap<>();
        q.offer(new Integer[]{arr[1], 0});
        h.put(arr[1], 0);
        loop:
        while(!q.isEmpty()){
            int val = q.peek()[0];
            int cnt = q.peek()[1];
            q.poll();
            for(i=3; i<5; i++){
               int next = val+arr[i];
               if(next>0 && next<=arr[0]){
                   if(!h.containsKey(next)) {
                       q.offer(new Integer[]{next, cnt + 1});
                       h.put(next, cnt + 1);
                   }
                   if (next == arr[2])
                       break loop;
               }
            }
        }
        if(h.containsKey(arr[2]))
            System.out.println(h.get(arr[2]));
        else
            System.out.println("use the stairs");
    }
}
