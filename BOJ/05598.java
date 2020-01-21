import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		int i;
		int tmp;
		for(i=0; i<ch.length; i++) {
			if(ch[i]-3<65)
				tmp=ch[i]+23;
			else
				tmp=ch[i]-3;
			System.out.print((char)tmp);
		}
	}	
}
