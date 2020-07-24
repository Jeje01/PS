// 블랙잭 - HashSet

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set hashSet = new HashSet();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int gap = Integer.MAX_VALUE;
		int answer=0;
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0; i<N-2; i++) {
			for(int j=i+1; j<N-1; j++) {
				for(int k=j+1; k<N; k++) {
					hashSet.add(arr[i]+arr[j]+arr[k]);
				}
			}
		}
		Iterator it = hashSet.iterator();
		while(it.hasNext()) {
			int nextOne = Integer.parseInt(it.next().toString());
			if(gap>M-nextOne && M>=nextOne) {
				gap = Math.abs(nextOne-M);
				answer = nextOne;
			}
		}
		System.out.println(answer);
	}

}
