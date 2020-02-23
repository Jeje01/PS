import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i, j, sum;
		int[] answer = new int[n];
		for(i=0; i<n; i++) {
			sum=0;
			String[] sp = sc.next().split("");
			for(j=0; j<24; j++) {
				sum+=Integer.parseInt(sp[j])*Math.pow(2,23-j);
			}
			answer[i]=sum;
		}
		for(i=0; i<n; i++) {
			System.out.println(answer[i]);
		}
	}
}
