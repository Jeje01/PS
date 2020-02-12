import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i, j, max, val;
		String ans="", s="";
		String[] arr = new String[t];
		for(i=0; i<t; i++) {
			max=0;
			int n = sc.nextInt();
			for(j=0; j<n; j++) {
				s=sc.next();
				val = sc.nextInt();
				if(val>max) {
					ans=s;
					max=val;
				}
			}
			arr[i]=ans;
		}
		for(i=0; i<t; i++)
			System.out.println(arr[i]);
	}	
}
