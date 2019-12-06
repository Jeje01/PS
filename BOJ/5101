import java.util.Scanner;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		List<Integer> x = new ArrayList<>();
		while(true) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			if(!(a==0&&b==0&&c==0)) {
				if((c-a)%b==0)
					x.add((c-a)/b+1);
				else
					x.add(0);
			}
			else
				break;
		}	
		for(int i : x) {
			if(i==0)
				System.out.println("X");
			else
				System.out.println(i);
		}
	  
	}
}
