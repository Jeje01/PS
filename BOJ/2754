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
		System.out.println(grade(sc.next()));
	}
}
