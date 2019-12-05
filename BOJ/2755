import java.util.Scanner;

public class Main {
	public static double grade(String s) {
		String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", 
				"C0", "C-", "D+", "D0", "D-", "F"};
		double[] ret = {4.3, 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0.0};
		int i; double answer=0;
		for(i=0; i<grade.length; i++) {
			if(s.equals(grade[i])) {
				answer = ret[i];
				break;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i, j;
		double sum = 0, total = 0;
		double[][] g = new double[n][2];
		for(i=0; i<n; i++) {
			String s = sc.next();
			g[i][0] = sc.nextDouble();
			g[i][1] = grade(sc.next());
			total +=g[i][0];
			sum+=g[i][0]*g[i][1];
		}
		System.out.println(String.format("%.2f", sum/total));
	}
}
