// Julka

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger all = sc.nextBigInteger();
		BigInteger c = sc.nextBigInteger();
		BigInteger temp = (all.subtract(c)).divide(BigInteger.valueOf(2));
		System.out.println(temp.add(c));
		System.out.println(temp);
	}
}
