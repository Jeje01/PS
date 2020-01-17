import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		float[] res = new float[t];
		int[] tot = new int[t];
		int i, j, n, c, total;
		float score, g;
		for(i=0; i<t; i++) {
			score=0; 
			total=0;
			n = sc.nextInt();
			for(j=0; j<n; j++) {
				c = sc.nextInt();
				g = sc.nextFloat();
				score+=c*g;
				total+=c;
			}
			res[i]=score/total;
			tot[i]=total;
		}
		for(i=0; i<t; i++) {
			System.out.print(tot[i]+" ");
			System.out.printf("%.1f", res[i]);
			System.out.println();
		}
	}	
}
