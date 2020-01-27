import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int i, g=1, up, tmp=1;
		for(i=1; i<Math.min(b,d); i++) {
			if(b%(i+1)==0 && d%(i+1)==0) {
				g=i+1;
			}
		}
		g=(b/g)*d;
		up=(g/b)*a+(g/d)*c;
		for(i=1; i<Math.min(up,g); i++) {
			if(up%(i+1)==0 && g%(i+1)==0) {
				tmp=i+1;
			}
		}
		up/=tmp;
		g/=tmp;
		System.out.println(up+" "+g);
	}	
}
