//문자열 내림차순으로 배치하기

import java.util.Arrays;

class Solution {
  public String solution(String s) {
        int i, len=s.length();
        int[] num = new int[len];
        String ans = "";
        for(i=0; i<len; i++){
            num[i]=(int)s.charAt(i);
        }
        Arrays.sort(num);
        for(i=len-1; i>=0; i--){
            ans+=String.valueOf((char)num[i]);
        }
        return ans;
    } 
}
