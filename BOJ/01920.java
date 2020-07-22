// 수 찾기 - Binary Search

import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int M = sc.nextInt();
		int[] answer = new int[M];
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			if(Arrays.binarySearch(arr, a)>=0)
				answer[i] = 1;
		}
		for(int a: answer)
			System.out.println(a);
	}

}
