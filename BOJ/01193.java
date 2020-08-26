/**
 * 분수찾기 - B2
 * 수학, 구현
 * 14,336 kb
 * 112 ms
 * 
 * 인덱스 주의
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int sum=0;
		int i=1;
		while(true) {
			if(sum+i<N) {
				sum+=i;
			}else {
				break;
			}
			i++;
		}
		if(i%2==0) {
			System.out.println((N-sum)+"/"+(i-N+sum+1));
		}else {
			System.out.println((i-N+sum+1)+"/"+(N-sum));

		}

	}
}
