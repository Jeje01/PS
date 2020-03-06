import java.util.ArrayList;
import java.util.Arrays;

//모의고사

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] cnt = new int[3];
        int[][] pick = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int i, j, max;
        for(i=0; i<answers.length; i++){
            for(j=0; j<3; j++){
                if(answers[i]==pick[j][i%pick[j].length]){
                    cnt[j]++;
                }
            }
        }
        max = Math.max(Math.max(cnt[0], cnt[1]), cnt[2]);
        for(i=0; i<3; i++){
            if(cnt[i]==max)
                list.add(i+1);
        }
        int[] array = new int[list.size()];
        for(i=0; i<array.length; i++){
            array[i]=list.get(i);
        }
        Arrays.sort(array);
        return array;    
    }
}
