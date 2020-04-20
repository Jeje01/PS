// Exhaustive Search

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt(), s = sc.nextInt(), m = sc.nextInt();
        int i=0, j=0;
        while(true){
            if((15*i+e-m)%19==0 && (15*i+e-s)%28==0){
                break;
            }else{
                i++;
            }
        }
        System.out.println(15*i+e);
    }
}
