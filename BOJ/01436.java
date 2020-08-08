/**
 * 영화감동 숌
 * Brute-force
 * 278,400 kb
 * 656 ms
 */
 
import java.util.Scanner;

public class Main {
	static int count=0, answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i=666;
		while(n!=10001) {
			String six = i+"";
			boolean check = false;
			for(int j=0; j<six.length()-2; j++) {
				if(six.substring(j, j+3).equals("666")) {
					check = true;
					break;
				}
			}
			if(check) {
				count++;
				if(count==n) {
					answer = i;
					break;
				}
			}
			i++;
			
		}
		System.out.println(answer);

	}

}
