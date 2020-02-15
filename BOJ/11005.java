import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int b = sc.nextInt();
		int tmp=0;
		ArrayList<Integer> list = new ArrayList<>();
		while(true) {
			list.add(n%b);
			n=(n-n%b)/b;
			if(n==0) break;
		}
		for(int i=list.size(); i>0; i--) {
			tmp=list.get(i-1);
			if(tmp<10)
				System.out.print(tmp);
			else
				System.out.print((char)(tmp+55));
		}
		System.out.println();			
	}
}
