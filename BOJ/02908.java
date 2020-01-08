import java.util.Scanner;

public class Main {
	public static int rev(int x) {
		int i, j;
		i=x/100;
		j=(x-i*100)/10;
		return (x%10)*100+j*10+i;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		if(rev(a)>rev(b))
			System.out.println(rev(a));
		else
			System.out.println(rev(b));
	}
}
