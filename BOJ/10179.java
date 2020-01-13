import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i;
		double tmp;
		double[] d = new double[t];
		for(i=0; i<t; i++) {
			d[i]=sc.nextDouble();
		}
		for(i=0; i<t; i++) {
			tmp=Math.round(d[i]*80)/100.0;
			System.out.print("$");
			System.out.printf("%.2f", tmp);
			System.out.println();
		}
	}
}
