//[1차] 비밀지도

class Solution {
  public int[] bin(int n, int len){
    int[] out = new int[len];
    int i = len-1;
    while(n!=0){
        out[i]=n%2;
        n/=2;
        i--;
    }
    return out;
  }
    
  public String[] solution(int n, int[] arr1, int[] arr2) {
    int len = arr1.length;
    String[] answer = new String[len];
    int i, j;
    for(i=0; i<len; i++){
        answer[i]="";
    }
    int[][] a = new int[len][len];
    int[][] b = new int[len][len];
    for(i=0; i<len; i++){
        a[i] = bin(arr1[i], len);
        b[i] = bin(arr2[i], len);
    }
    for(i=0; i<len; i++){
        for(j=0; j<len; j++){
            if(a[i][j]==0 && b[i][j]==0)
                answer[i]+=" ";
            else
                answer[i]+="#";
        } 
    }
  return answer;
  }
}
