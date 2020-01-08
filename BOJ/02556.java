import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[9][9];
		int i, j, max=0, ai=0, aj=0;
		for(i=0; i<9; i++)
			for(j=0; j<9; j++)
				arr[i][j]= sc.nextInt();
		for(i=0; i<9; i++)
			for(j=0; j<9; j++) {
				if(max < arr[i][j]) {
					ai=i+1;
					aj=j+1;
					max = arr[i][j];
					}
			}
		System.out.println(max+"\n"+ai+" "+aj);
	}
}
