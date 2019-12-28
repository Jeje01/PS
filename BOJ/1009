import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i, j, a, b, value, tmp;
		int[] arr = new int[t];
		for(i=0; i<t; i++) {
			 a = sc.nextInt();
			 b = sc.nextInt();
			 if(b%4==0) tmp=4;
			 else tmp=b%4;
			 value=(int)Math.pow(a, tmp);
			 arr[i]=value%10;
		}
		for(i=0; i<t; i++) {
			if(arr[i]==0)
				System.out.println(10);
			else
				System.out.println(arr[i]);}
	}
}
