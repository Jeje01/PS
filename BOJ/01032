import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i;
		char[][] ch= new char[n][];
		char[] compare = (sc.next()).toCharArray();
		int len = compare.length;
		for(i=1; i<n; i++) {
			ch[i]=(sc.next()).toCharArray();
		}
		char[] res = new char[len];
		for(i=1;i<n; i++) {
			for(int j = 0; j<len; j++) {
				if(compare[j]!=ch[i][j])
					compare[j]='?';
			}
		}
		for(i=0;i<len; i++)
			System.out.print(compare[i]);		
	}
}
