//소수 찾기

class Solution {
  public int solution(int n) {
        int[] arr = new int[n+1];
        int i, j, answer=0;
        for(i=2; i<n+1; i++){
            if(arr[i]==1) continue;
            for(j=i*2; j<n+1; j+=i) {
                arr[j] = 1;
            }
        }
        for(i=2; i<n+1; i++)
            if(arr[i]!=1) {
                answer++;
            }
        return answer;

  }
}