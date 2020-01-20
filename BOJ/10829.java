import java.util.Scanner;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		long n = sc.nextLong();
		long check=2;
		int i, index=0;
		while(true) {
			if(n%check==0)
				list.add(0);
			else
				list.add(1);
			
			n-=n%check;
			check*=2;
			if(n==0) break;
		}
		for(i=0; i<list.size(); i++) {
			index = list.size()-i-1;
			System.out.print(list.get(index));
		}
	}	
}
