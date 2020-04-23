// BFS - 물통

import java.util.*;

public class Main {
    public static void main(String[] args){
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> h = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int[] limit = new int[3];
        int i, j, k;
        for(i=0; i<limit.length; i++){
            limit[i] = sc.nextInt();
        }
        String start = 0+" "+0+" "+limit[2];
        q.offer(start);
        h.put(start, limit[2]);
        while(!q.isEmpty()){
            String[] sp = q.poll().split(" ");
            int[] out = new int[3];
            for(i=0; i<3; i++){
                out[i] = Integer.parseInt(sp[i]);
            }
            for(i=0; i<3; i++){
                if(out[i]!=0){
                    for(j=0; j<3; j++){
                        if(j==i) continue;
                        int[] tmp = new int[3];
                        String str = "";
                        for(k=0; k<3; k++)
                            tmp[k] = out[k];
                        if(out[i]<=limit[j]-tmp[j]){
                            tmp[j] =tmp[j]+tmp[i];
                            tmp[i] = 0;
                        }else{
                            tmp[i]-=limit[j]-tmp[j];
                            tmp[j]=limit[j];
                        }
                        for(k=0; k<3; k++){
                            str+=tmp[k];
                            if(k!=2) str+=" ";
                        }
                        if(!h.containsKey(str)) {
                            h.put(str, tmp[2]);
                            q.offer(str);
                        }
                    }
                }
            }
        }
        Iterator<String> keys = h.keySet().iterator();
        while(keys.hasNext()){
            String s = keys.next();
            int n = Integer.parseInt(s.split(" ")[0]);
            if(n==0)
                list.add(h.get(s));
        }
        Collections.sort(list);
        for(i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
