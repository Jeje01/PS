import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int i, a, b, c;
        for(i=1; i<n+1; i++){
            if(i==1) arr[i]=1;
            else if(i<100) arr[i] = arr[i-1] + 1;
            else if(i==1000) arr[i] = arr[i-1];
            else {
                c = i%10;
                b = (i/10)%10;
                a = i/100;
                if((a-b)==(b-c)){
                    arr[i] = arr[i-1]+1;
                }
                else{
                    arr[i] = arr[i-1];
                }
            }
        }
        System.out.println(arr[n]);
    }
}
