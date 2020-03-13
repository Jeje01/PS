//구명보트 - 탐욕법

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0, front=0, end=people.length-1;
        int[] check = new int[people.length];
        Arrays.sort(people);
        while(true){
            if(check[front]==1 || check[end]==1) break;
            if(people[front]+people[end]>limit){
                check[end]=1;
                end--;
            }
            else{
                check[front]=1;
                check[front]=1;
                end--;
                front++;;
            }
            answer++;
            if(end<0 || front==people.length)
                break;
        }
        return answer;
    }
}
