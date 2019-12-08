import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] s = new double[n];
		int i;
		double max=0, sum=0;
		for(i=0; i<n; i++) {
			s[i] = sc.nextDouble();
			if(i==0)
				max = s[i];
			else
				max = max >s[i] ? max : s[i];
		}
		for(i=0; i<n; i++)
			sum += s[i]/max*100;
		System.out.println(sum/n);
	}
}
