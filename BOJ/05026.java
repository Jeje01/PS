import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i;
		int[] arr = new int[n];
		for(i=0; i<n; i++) {
			String s = sc.next();
			String[] sp = s.split("\\+");
			if(sp.length==1) {
				arr[i]=-1;
			}
			else {
				arr[i]=Integer.parseInt(sp[0])+Integer.parseInt(sp[1]);
			}	
		}
		for(i=0; i<n; i++) {
			if(arr[i]==-1)
				System.out.println("skipped");
			else
				System.out.println(arr[i]);
		}
	}	
}
