import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int i, j, sum=0, min=0, check=0;
		int n = sc.nextInt();
		int[][] arr = new int[n][7];
		for(i=0; i<n; i++)
			for(j=0; j<7; j++)
				arr[i][j]=sc.nextInt();
 		for(i=0; i<n; i++){
			sum=0; check=0;
			for(j=0; j<7; j++){
				if(arr[i][j]%2==0){
					if(check==0) {
						min=arr[i][j];
						check=1;
					}					
					else
						min=min<arr[i][j]? min: arr[i][j];
					sum+=arr[i][j];
				}
			}
			System.out.println(sum+" "+min);
 		}
	}
}
