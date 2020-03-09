//N개의 최소공배수

class Solution {
    public int gcd(int a, int b){
        int g=1, i;
        for(i=1; i<=Math.min(a, b); i++){
            if(a%i==0 && b%i==0)
                g=i;
        }
        System.out.println("g="+g);
        return g;
    }
    public int lcm(int a, int b){
        return a*b/gcd(a, b);
    }
    
    public int solution(int[] arr) {
        int i, l=arr[0];
        for(i=1; i<arr.length; i++){
            l = lcm(l, arr[i]);
            System.out.println(i+"= "+l);
        }
        return l;
    }
}
