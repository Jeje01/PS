import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i, j;
		double[] ans = new double[t];
		for(i=0; i<t; i++) {
			double answer = sc.nextDouble();		
			String s = sc.nextLine();
			String[] sp = s.split(" ");
			for(j=0; j<sp.length; j++) {
				if(sp[j].equals("@")) {
					answer*=3;
				} else if(sp[j].equals("%")) {
					answer+=5;
				} else if(sp[j].equals("#")) {
					answer-=7;
				}
			}
			ans[i] = answer;
		}
		for(i=0; i<t; i++) {
			System.out.printf("%.2f", ans[i]);
			System.out.println();
		}
	}	
}
