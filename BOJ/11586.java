import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i, j;
		char[][] ch = new char[n][];
		for(i=0; i<n; i++) {
			ch[i] = sc.next().toCharArray();
		}
		int k = sc.nextInt();
		if(k==1) {
			for(i=0; i<n; i++) {
				for(j=0; j<n; j++) {
					System.out.print(ch[i][j]);
				}
				System.out.println();
			}
		}else if(k==2) {
			for(i=0; i<n; i++) {
				for(j=n-1; j>=0; j--) {
					System.out.print(ch[i][j]);
				}
				System.out.println();
			}			
		}else {
			for(i=n-1; i>=0; i--) {
				for(j=0; j<n; j++) {
					System.out.print(ch[i][j]);
				}
				System.out.println();
			}
		}
	}	
}
 
