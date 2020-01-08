import java.util.Scanner;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		int[] answer = new int[n];
		int i, pos=0;
		for(i=0; i<n; i++) {
			arr.add(i+1);	
		}
		System.out.print('<');
		for(i=0; i<n; i++) {
			pos=(pos+k-1)%arr.size();
			System.out.print(arr.get(pos));
			arr.remove(pos);
			if(i!=n-1)
				System.out.print(", ");
		}
		System.out.println('>');	
	}
}
