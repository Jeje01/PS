import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i, cnt = 0, input;
		int[] arr = new int[100];
		for(i=0; i<100; i++)
			arr[i]=0;
		for(i=0; i<n; i++) {
			input = sc.nextInt();
			if(arr[input-1]!=1)
				arr[input-1]=1;
			else
				cnt++;
		}
		System.out.println(cnt);	
	}
}
