import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int[] arr = {1, 0, 0};
		int m = sc.nextInt();
		int i, tmp=0;
		for(i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			tmp=arr[a-1];
			arr[a-1]=arr[b-1];
			arr[b-1]=tmp;
		}
		for(i=0; i<3; i++) {
			if(arr[i]==1) {
				System.out.println(i+1);
				break;
			}
		}
		if(i==3)
			System.out.println(-1);
	}
}
