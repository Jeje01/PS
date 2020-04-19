// Greedy

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;

//양수 합
    public static int getPos(int start){
        int sum=0, len = arr.length;
        for(int i=len-1; i>start; i=i-2){
            sum+=arr[i]*arr[i-1];
        }
        if((len-start)%2!=0) { //양수 홀수 개
            sum += arr[start];
        }
        return sum;
    }
//음수 합
    public static int getNeg(int end){
        int sum=0;
        for(int i=0; i<end; i=i+2){
            sum += arr[i]*arr[i+1];
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        int i, zero=-1, sum=0, posNum = -1;
        for(i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(i=0; i<n; i++){
            if(arr[i]==0){
                if(zero==-1)
                    zero = i;
            }else if(arr[i]>0){
                posNum = i;
                break;
            }
        }
        
        //양수가 있다면
        if(posNum!=-1) {
            int tmp = posNum;
            while (arr[tmp] == 1) {
                sum++;
                tmp++;
                if(tmp==n) break;
            }
            if(tmp<n) sum += getPos(tmp);
        }
        
        //음수가 있다면
        if(zero!=0 && !(zero==-1 && posNum==0)){
            int end;
            if(zero==-1){
                if(posNum==-1)
                    end = n-1;
                else{
                    end = posNum-1;
                }
            } else{
                end = zero-1;
            }
            if((end+1)%2==0){ //짝수 개
                sum += getNeg(end);
            }else{ //홀수 개
                if((end+1)!=1)
                    sum += getNeg(end-1);
                if(zero==-1) //0이 없을 때
                    sum += arr[end];
            }
        }
        System.out.println(sum);
    }
}
