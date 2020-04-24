import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] answer = new int[n];
        int i, j, k;
        int[][] inp = new int[3][n];
        for(i=0; i<n; i++){
            for(j=0; j<3; j++){
               inp[j][i] = sc.nextInt();
            }
        }
        for(i=0; i<3; i++){
            boolean[] check = new boolean[n];
            for(j=0; j<n; j++){
                for(k=0; k<n; k++){
                    if(j==k) continue;
                    if(inp[i][j]==inp[i][k]) {
                        check[j] = true;
                        check[k] = true;
                        break;
                    }
                }
            }
            for(j=0; j<n; j++){
                if(check[j]==false)
                    answer[j] +=inp[i][j];
            }
        }
        for(i=0; i<n; i++)
            System.out.println(answer[i]);
    }
}
