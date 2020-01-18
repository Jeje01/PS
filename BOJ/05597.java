import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[30];
		int[] answer = new int[2];
		int i, pos=0, tmp;
		for(i=0; i<30; i++)
			arr[i]=0;
		for(i=0; i<28; i++) {
			tmp=sc.nextInt();
			arr[tmp-1]=1;
		}
		for(i=0; i<30; i++) {
			if(arr[i]==0) {
				answer[pos++]=i+1;
			}
		}
		Arrays.sort(answer);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}	
}
