import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int zr = sc.nextInt();
		int zc = sc.nextInt();
		char[][] ch= new char[r][c];
		int i, j, k, l;
		for(i=0; i<r; i++) {
			ch[i]=sc.next().toCharArray();		
		}
		for(i=0; i<r; i++) {
			for(k=0; k<zr; k++) {
				for(j=0; j<c; j++) {
					for(l=0; l<zc; l++)
						System.out.print(ch[i][j]);
				}
			System.out.println();
			}
		}
	}	
}
