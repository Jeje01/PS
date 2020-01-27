import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i;
		int[] arr = new int[t];
		for(i=0; i<t; i++){
			arr[i]=sc.nextInt()+sc.nextInt();
		}
		for(i=0; i<t; i++) {
			System.out.println("Case "+(i+1)+": "+arr[i]);
		}
	}	
}
