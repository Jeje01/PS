import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String none = sc.next();
		//char none = sc.next().charAt(0);
		String[] s = new String[n];
		int i, j, k;
		for(i=0; i<n; i++) {
			s[i]=sc.nextLine();
		}
		for(i=0; i<n; i++) {
			String[] sp = s[i].split(" ");
			if(i==0) sp[0]=none;
			for(j=0; j<sp.length; j++) {
				for(k=0; k<sp[j].length(); k++) {
					System.out.print(sp[j].charAt(sp[j].length()-1-k));
				}
				System.out.print(" ");
			}System.out.println();
		}
	}
}
