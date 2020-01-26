import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i, a, b, c, tmp;
		int[] prize = new int[n];
		for(i=0; i<n; i++) {
			a= sc.nextInt();
			b= sc.nextInt();
			c= sc.nextInt();
			if(a==b) {
				if(b==c) { //1
					prize[i]=10000+a*1000;
				}
				else { //2, a==b
					prize[i]=1000+a*100;
				}
			}//a!=b
			else {
				if(a==c||b==c) { //2
					prize[i]=1000+c*100;
				}
				else { //3
					prize[i]=100*Math.max(a, Math.max(b, c));
				}
			}
		}
		Arrays.sort(prize);
		System.out.println(prize[n-1]);
	}	
}
