import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i, j;
		int y, k;
		String[] answer = new String[t];
		for(i=0; i<t; i++) {
			y=0; k=0;
			for(j=0; j<9; j++) {
				y+=sc.nextInt();
				k+=sc.nextInt();
			}
			if(y==k) 
				answer[i]="Draw";
			else if(y<k)
				answer[i]="Korea";
			else
				answer[i]="Yonsei";
		}
		for(i=0; i<t; i++)
			System.out.println(answer[i]);
	}	
}
