//[1차] 다트 게임

class Solution {
    public int getSq(char c){
        if(c=='S')
        return 1;
        else if(c=='D')
        return 2;
        else 
        return 3;
    }
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        int[] op = {1, 1, 1};
        int pos = 0, scPos=0, i;
        char[] ch = dartResult.toCharArray();
        while(pos<dartResult.length()){
            if(ch[pos]=='1' && ch[pos+1]=='0'){
                score[scPos]=10;
                score[scPos] = (int)Math.pow(score[scPos], getSq(ch[pos+2]));
                pos+=3; scPos++;
            }
            else{
                score[scPos]=Integer.parseInt(String.valueOf(ch[pos]));
                score[scPos]= (int)Math.pow(score[scPos], getSq(ch[pos+1]));
                pos+=2; scPos++;
            }
            if(pos==dartResult.length()) break;
            if(ch[pos]=='*'){
                if(scPos==1){
                    op[scPos-1]*=2;
                }
                else{
                    op[scPos-1]*=2;
                    op[scPos-2]*=2;
                }
                pos++;
            }
            else if(ch[pos]=='#'){
                op[scPos-1]*=-1;
                pos++;
            }
        }
        for(i=0; i<3; i++){
            answer+=score[i]*op[i];
        }
        return answer;     
    }
}

