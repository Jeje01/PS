//기능개발(스택/큐)

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0, front = 0, pos = 0, i;
        int[] days = new int[progresses.length];
        for(i = 0; i<days.length; i++){
            days[i] =((100-progresses[i])%speeds[i]==0) ? (100-progresses[i])/speeds[i] : (100-progresses[i])/speeds[i] +1;  
        }
        front = days[pos++];
        cnt++;
        do{
            if(front>=days[pos]){
                pos++;
                cnt++;
            } 
            else {
                list.add(cnt);
                System.out.println(cnt);
                cnt=1;
                front=days[pos++];
            }
        }while(pos!=days.length);
        list.add(cnt);
        int[] answer = new int[list.size()];
        for(i=0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}