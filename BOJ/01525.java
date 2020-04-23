// BFS, Exhaustive Search - 퍼즐

import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> h = new HashMap<>();
        int i, start=0, answer=-1;
        for(i=0; i<9; i++){
            int input = sc.nextInt();
            if(input==0) input = 9;
            start = start*10 + input;
        }
        int goal = 123456789;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        q.offer("" +start);
        h.put("" + start, 0);
        
        // string -> 좌표 : swap
        // 좌표 -> string : put, offer
        loop:
        while(!q.isEmpty()){
            String tmp = q.poll();
            int ind = tmp.indexOf('9');
            int a = ind/3;
            int b = ind%3;
            int cnt = h.get(tmp);
            for(i=0; i<4; i++){
                StringBuilder sb = new StringBuilder(tmp);
                int nexta = a+dx[i];
                int nextb = b+dy[i];
                if(nexta>=0 && nexta<3 && nextb>=0 && nextb<3){
                    char ch = sb.charAt(nexta*3+nextb);
                    sb.setCharAt(ind, ch);
                    sb.setCharAt(nexta*3+nextb, '9');
                    String str = sb.toString();
                    if(!h.containsKey(str)) {
                        h.put(str, cnt + 1);
                        q.offer(str);
                        if(str.equals("123456789")) {
                            break loop;
                        }
                    }
                }
            }
        }
        Iterator<String> keys = h.keySet().iterator();
        while(keys.hasNext()){
            if(keys.next().equals("123456789")){
                answer = h.get("123456789");
            }
        }
        System.out.println(answer);
    }
}
