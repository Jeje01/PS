import java.util.Scanner;

public class Main{
	public static int rec(int x) {
		int a, b;
		a=x/10;
		b=x%10;
		return b*10+(a+b)%10;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int tmp=n, cnt=0;
		while(true) {
			tmp=rec(tmp);
			cnt++;
			if(n==tmp)
				break;
		}
		System.out.println(cnt);
	}
}
