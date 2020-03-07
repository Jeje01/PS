//다음 큰 숫자

class Solution {
    public int bin(int n){
        int cnt=0;
        while(n!=0){
            if(n%2==1) cnt++;
            n=(n-n%2)/2;
        }
        return cnt;
    }
  public int solution(int n) {
      int answer = n+1;
      int num = bin(n);
      while(true){
          if(bin(answer)==num)
              break;
          answer++;
      }
      return answer;
  }
}