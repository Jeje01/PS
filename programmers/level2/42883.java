//큰 수 만들기 - Greedy

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length();
        char[] ch = number.toCharArray();
        int i, j, max=0, pos=0;
        for(i=0; i<len-k; i++){
            max=0;
            for(j=pos; j<k+i+1; j++){
                if(ch[j]-48 > max){
                    max = ch[j]-48;
                    pos=j+1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
