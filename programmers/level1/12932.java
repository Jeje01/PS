//자연수 뒤집어 배열로 만들기

//1
import java.util.stream.Stream;

class Solution {
  public int[] solution(long n) {
        int[] digits = Stream.of(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
        int[] ans = new int[digits.length];
        for(int i=0; i<ans.length; i++){
            ans[i]=digits[digits.length-i-1];
        }
        return ans;
  }
}


//2   -> faster
import java.util.ArrayList;

class Solution {
  public int[] solution(long n) {
        ArrayList<Integer> list = new ArrayList<>();
        while (n!=0) {
            list.add((int)(n%10));
            n/=10;
        }
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i]=list.get(i);
        }
        return ans;
  }
}
