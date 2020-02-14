import java.util.Scanner;

public class Main {
	public static int rev(int n) {
		int i;
		String cnv="";
		String s = String.valueOf(n);
		for(i=s.length()-1; i>=0; i--) {
			cnv+=s.charAt(i);
		}
		return Integer.parseInt(cnv);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(rev(rev(a)+rev(b)));
	}	
}
