import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int first = 0, sum=0, value=0;
		int i;
		for(i=(int)Math.sqrt(m); i<=(int)Math.sqrt(n)+1; i++) {
			if((i*i>=m)&&(i*i<=n)) {
				sum += i*i;
				if(first==0) {
					first++;
					value=i*i;
				}
			}
			if(i*i>n) break;
			
		}
		if(first==0) {
			System.out.println(-1);
		}
		else {
		System.out.println(sum);
		System.out.println(value);
		}
	}
}
