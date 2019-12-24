import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		char[][] arr = new char[t][];
		int i, j, left, no;
		for(i=0; i<t; i++) {
			arr[i]=sc.next().toCharArray();
		}
		for(i=0; i<t; i++) {
			left=0; no=0;
			loop : for(j=0; j<arr[i].length; j++) {
				if(arr[i][j]=='(')
					left++;
				else {
					if(left==0) {
						System.out.println("NO");
						no=1;
						break loop;
					}
					else
						left--;
				}
			}
			if(no!=1 && left==0)
				System.out.println("YES");
			if(no!=1 && left!=0)
				System.out.println("NO");
		}
	}
}
