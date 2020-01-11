import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i;
		String[] str = new String[2];
		int[] res = new int[t];
		for(i=0; i<t; i++) {
			str=sc.next().split(",");
			res[i]=Integer.parseInt(str[0])+Integer.parseInt(str[1]);
		}
		for(i=0; i<t; i++)
			System.out.println(res[i]);
	}
}
