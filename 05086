import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		int a,b;
		while(true) {
			a=sc.nextInt();
			b=sc.nextInt();
			if(a==0&&b==0)
				break;
			else {
				if(b%a==0)
					list.add("factor");
				else if(a%b==0)
					list.add("multiple");
				else
					list.add("neither");					
			}
		}
		for(String i:list) {
			System.out.println(i);
		}
	}
}
