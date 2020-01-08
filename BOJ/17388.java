import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		int i;
		for(i=0; i<3; i++)
			arr[i]=sc.nextInt();
		int tmp;
		if(arr[0]+arr[1]+arr[2]>=100)
			System.out.println("OK");
		else {
			tmp=Math.min(arr[2], Math.min(arr[0], arr[1]));
			if(tmp==arr[0])
				System.out.println("Soongsil");
			else if(tmp==arr[1])
				System.out.println("Korea");
			else
				System.out.println("Hanyang");
		}		
	}
}
