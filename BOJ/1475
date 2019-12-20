import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max=0;
		int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		while(true) {
			arr[n%10]++;
			n/=10;
			if(n==0) break;
		}
		if((arr[6]+arr[9])%2==0)
			arr[6]=(arr[6]+arr[9])/2;
		else
			arr[6]=(arr[6]+arr[9]+1)/2;
		for(int i = 0; i<9; i++) {
			max = max<arr[i] ? arr[i] : max;				
		}
		System.out.println(max);
	}
}
