import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int date = sc.nextInt();
		int i, cnt=0; 
		for(i=0; i<5; i++) {
			if(sc.nextInt()==date)
				cnt++;
		}
		System.out.println(cnt);			
	}
}
