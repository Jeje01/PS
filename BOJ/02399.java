// 거리의 합

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long answer = 0;
		int[] x = new int[n];
		for(int i=0; i<n; i++)
			x[i] = sc.nextInt();
		Arrays.sort(x);
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				answer+=2*Math.abs(x[j]-x[i]);
			}
		}
		System.out.println(answer);

	}
}
