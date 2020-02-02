import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i, j, max, num;
		String[] answer = new String[n];
		for(i=0; i<n; i++) {
			int p = sc.nextInt();
			int[] arr = new int[p];
			String[] name = new String[p];
			for(j=0; j<p; j++) {
				arr[j]=sc.nextInt();
				name[j]=sc.next();
			}
			max=arr[0];
			num=0;
			for(j=1; j<p; j++) {
				if(arr[j]>max) {
					max=arr[j];
					num=j;
				}
			}
			answer[i]=name[num];
		}
		for(i=0; i<n; i++)
			System.out.println(answer[i]);
	}	
}
