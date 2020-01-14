import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		int i;
		for(i=0; i<3; i++)
			arr[i]=sc.nextInt();
		char[] ch = (sc.next()).toCharArray();
		Arrays.sort(arr);
		for(i=0; i<3; i++) {
			System.out.print(arr[ch[i]-65]+" ");
		}	
	}
}
