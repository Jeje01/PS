import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		String[] ans = new String[n];
		int i, j;
		String tmp = sc.next();
		for(i=0; i<n; i++) {
			String input = sc.nextLine();
			String[] sp = input.split(" ");
			if(i==0) sp[0]=tmp;
			if(sp[1].equals("+")) {
				if(Integer.parseInt(sp[0])+Integer.parseInt(sp[2])
				==Integer.parseInt(sp[4]))
					ans[i]="YES";
				else
					ans[i]="NO";
			}else {
				if(Integer.parseInt(sp[0])-Integer.parseInt(sp[2])
				==Integer.parseInt(sp[4]))
					ans[i]="YES";
				else
					ans[i]="NO";
			}
		}
		for(i=0; i<n; i++) {
			System.out.println("Case "+(i+1)+": "+ans[i]);
		}
	}
}
