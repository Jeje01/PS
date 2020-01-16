import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int i, p, m, j, cnt, seat;
		int[] answer = new int[k];
		for(i=0; i<k; i++) {
			cnt=0;
			p = sc.nextInt();
			m = sc.nextInt();
			int[] arr = new int[m];
			for(j=0; j<m; j++) {
				arr[j]=0;
			}
			for(j=0; j<p; j++) {
				seat=sc.nextInt();
				if(arr[seat-1]==0)
					arr[seat-1]++;
				else
					cnt++;
			}	
			answer[i]=cnt;
		}
		for(i=0; i<k; i++)
			System.out.println(answer[i]);
		
	}
}
