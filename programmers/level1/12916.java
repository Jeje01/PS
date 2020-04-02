class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        char[] ch = s.toCharArray();
        int cntp=0;
        int cnty=0;
        for(int i = 0; i<len; i++){
            if(ch[i]=='p'||ch[i]=='P') cntp++;
            if(ch[i]=='y'||ch[i]=='Y') cnty++;
        }
        if(cntp==cnty) answer = true;
        else answer = false;

        return answer;
    }
}
