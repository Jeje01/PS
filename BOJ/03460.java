import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void printAns(int a) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int check=2, i;
		while(true) {
			if(a%check==0)
				list.add(0);
			else 
				list.add(1);
			a-=a%check;
			check*=2;
			if(a==0)
				break;
		}
		for(i=0; i<list.size(); i++) {
			if(list.get(i)==1)
				System.out.print(i+" ");
		}
		System.out.println();		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] input = new int[t];
		int i;
		for(i=0; i<t; i++)
			input[i]=sc.nextInt();
		for(i=0; i<t; i++)
			printAns(input[i]);
	}	
}
