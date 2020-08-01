/**
 * 팰토리얼 0의 개수
 * 큰 수 연산 / 수학
 * 14,328 kb
 * 108 ms
 */
 
import java.util.Scanner;

public class Main {
	static long twos;
	static long fives;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		
		for(int i=1; i<=n; i++) {
			int tmp=i;
			while(tmp%2==0) {
				tmp/=2;
				twos++;
			}
			while(tmp%5==0) {
				tmp/=5;
				fives++;
			}
		}
		System.out.println(Math.min(twos, fives));
	}
}
