import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[2][10];
		int i, j, a=0, b=0;
		char[] ch = new char[10];
		for(i=0; i<2; i++) {
			for(j=0; j<10; j++)
				arr[i][j]=sc.nextInt();
		}
		for(i=0; i<10; i++) {
			if(arr[0][i]>arr[1][i]) {
				ch[i]='A';
				a+=3;
			}
			else if(arr[0][i]<arr[1][i]) {
				ch[i]='B';
				b+=3;
			}
			else {
				ch[i]='D';
				a++; b++;
			}
		}
		System.out.println(a+" "+b);
		if(a>b) System.out.println('A');
		else if(b>a) System.out.println('B');
		else {
			for(i=9; i>=0; i--) {
				if(ch[i]=='D')
					continue;
				else if(ch[i]=='A') {
					System.out.println('A');
					break;
				}
				else if(ch[i]=='B') {
					System.out.println('B');
					break;
				}
			}
			if(i==-1)
				System.out.println('D');
		}
	
	}
}
