/**
 * 셀프 넘버
 * 구현
 * 43,960 kb
 * 248 ms
 */
 
 public class Main {
    static StringBuilder output = new StringBuilder();
    static boolean[] dp;
    
    public static int d(String n) {
        int tmp=Integer.parseInt(n);
        for(int i=0; i<n.length(); i++) {
            tmp+=n.charAt(i)-'0';
        }
        return tmp;
    }
    
    public static void main(String[] args) {
        dp = new boolean[10001];
        for(int i=1; i<dp.length; i++) {
            if(dp[i]) continue;
            int n=i;
            while(true) {
                int res = d(n+"");
                if(res>10000)
                    break;
                else
                    dp[res] = true;
                n = res;
            }
            
        }
        for(int i=1; i<dp.length; i++) {
            if(!dp[i])
                output.append(i).append("\n");
        }
        System.out.println(output.toString());

    }

}
