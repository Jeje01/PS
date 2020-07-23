// 5와 6의 차이

import java.util.Scanner;

public class Main {
    static int min;
    static int max;
    static void minMax(String a){
        String minValue="";
        String maxValue="";
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)=='5'||a.charAt(i)=='6'){
                minValue+='5';
                maxValue+='6';
            }else{
                minValue+=a.charAt(i);
                maxValue+=a.charAt(i);
            }
        }
        min+=Integer.parseInt(minValue);
        max+=Integer.parseInt(maxValue);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextInt()+"";
        String b = sc.nextInt()+"";
        minMax(a); minMax(b);
        System.out.println(min+" "+max);
    }
}
