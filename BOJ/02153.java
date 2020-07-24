// 소수 단어

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int sum = 0;
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch>=65 && ch<=90) {
				sum+=ch-64;
			}else if(ch>=97 && ch<=123) {
				sum+=ch-96;
			}
		}
		boolean[] isNotPrime = new boolean[sum+1];
		for(int i=2; i<sum+1; i++) {
			if(isNotPrime[i]) continue;
			for(int j=2; j<sum; j++) {
				if(i*j>=sum+1) break;
				isNotPrime[i*j] = true;
			}
		}
		if(isNotPrime[sum])
			System.out.println("It is not a prime word.");
		else
			System.out.println("It is a prime word.");
	}
}
