//체육복(Greedy)

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer=n;
        int[] all = new int[n+1];
        int i;
        for(i=1; i<n+1; i++)
            all[i]=1;
        for(i=0; i<lost.length; i++){
            all[lost[i]]--;
        }
        for(i=0; i<reserve.length; i++){
            all[reserve[i]]++;
        }
        for(i=1; i<n+1; i++){
            if(all[i]==0){
                if(i!=1 && all[i-1]==2){
                    all[i-1]--;
                    all[i]++;
                }
                else if(i!=n && all[i+1]==2){
                    all[i+1]--;
                    all[i]++;
                }
            }
        }
        for(i=1; i<n+1; i++){
            if(all[i]==0)
                answer--;
        }
        return answer;
    }
}
