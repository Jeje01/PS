import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int i, g=1;
		for(i=1; i<Math.min(a,b); i++) {
			if(a%(i+1)==0 && b%(i+1)==0) {
				g=i+1;
			}
		}
		System.out.println(g+"\n"+(a/g*b));
	}	
}
