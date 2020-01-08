import java.util.*;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		List<String> x = new ArrayList<>();
		int a=0, b=0;
		while(true) {
			a = sc.nextInt();
			b = sc.nextInt();
			if(a==0&&b==0)
				break;
			else {
				if(a>b)
					x.add("Yes");
				else
					x.add("No");
			}	
		}
		for(String s : x)
			System.out.println(s);
	}
}
