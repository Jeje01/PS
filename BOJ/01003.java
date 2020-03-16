import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[41][2];
        int i;
        int t = sc.nextInt();
        int[] input = new int[t];
        for(i=0; i<t; i++){
            input[i] = sc.nextInt();
        }
        for(i=0; i<arr.length; i++){
            if(i<2) arr[i][i]=1;
            else{
                arr[i][0] = arr[i-1][0]+arr[i-2][0];
                arr[i][1] = arr[i-1][1]+arr[i-2][1];
            }
        }
        for(i=0; i<t; i++){
            System.out.println(arr[input[i]][0]+" "+arr[input[i]][1]);
        }

    }
}
