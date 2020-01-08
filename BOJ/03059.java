import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i, j;
		
		char[][] ch = new char[t][];
		for(i=0; i<t; i++) {
			ch[i]= (sc.next()).toCharArray();
		}
		for(i=0; i<t; i++) {
			int[] check = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90};
			int sum=0;
			for(j=0; j<ch[i].length; j++) {
				if(check[ch[i][j]-65]!=0)
					check[ch[i][j]-65]=0;
			}
			for(j=0; j<check.length; j++)
				sum+=check[j];
			System.out.println(sum);
		}
	}
}
