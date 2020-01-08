import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int i, pos=0, input, answer=0;
		int[] arr = new int[k];
		for(i=0; i<k; i++) {
			input = sc.nextInt();
			if(input!=0)
				arr[pos++] = input;
			else
				pos--;
		}
		for(i=0; i<pos; i++)
			answer+=arr[i];
		System.out.println(answer);
	}
}
