//brute force

import java.util.Arrays;

class Solution {
    public int func(int cnt, int[] check, int i){
        while(i!=0){
            if(check[i%10]>0){
                check[i%10]--;
            }
            else break;
            i/=10;
        }
        if(i==0) {
            System.out.println("확인");
            return cnt+1;
        }
        else
            return cnt;
    }
    public int solution(String numbers) {
        String[] sp = numbers.split("");
        int i, j, maxnum = 0, cnt=0;
        String max="";
        int[] check = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Arrays.sort(sp);
        for(i=sp.length-1; i>=0; i--){
            max += sp[i];
            check[Integer.parseInt(sp[i])]++;
        }
        int[] array = Arrays.copyOf(check, check.length);
        maxnum = Integer.parseInt(max);
        System.out.println(maxnum);
        int[] dp = new int[maxnum+1];
        //에라토스테네스의 체
        for(i=2; i<dp.length; i++){ //0 : 소수
            for(j=i*2; j<dp.length; j=j+i){
                dp[j] = 1;
            }
        }
        for(i=2; i<dp.length; i++){ //조합으로 만들 수 있는지 확인
            if(dp[i]==0){
                check = Arrays.copyOf(array, array.length);
                cnt = func(cnt, check, i);
            }
        }
        return cnt;
    }
}
