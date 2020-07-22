// 소트인사이드 - 정렬

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] sp = sc.next().split("");
		String answer="";
		Arrays.sort(sp, Comparator.reverseOrder());
		for(String s: sp) {
			answer+=s;
		}
		System.out.println(answer);
	}
}
