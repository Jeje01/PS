import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String[] sp = sc.next().split(",");
		int i, sum=0;
		for(i=0; i<sp.length; i++) {
			sum+=Integer.parseInt(sp[i]);
		}
		System.out.println(sum);
		
	}
}
