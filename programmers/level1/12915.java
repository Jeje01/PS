//문자열 내 마음대로 정렬하기

import java.util.Arrays;

class Solution {
  public String[] solution(String[] strings, int n) {
      String[] answer = new String[strings.length];
      for(int i = 0; i < strings.length; i++) {
          answer[i] = strings[i].substring(n, n+1) + strings[i];
      }
      Arrays.sort(answer);
      for(int i = 0; i < answer.length; i++) {
          answer[i] = answer[i].substring(1, answer[i].length());
      }
      return answer;
  }
}
