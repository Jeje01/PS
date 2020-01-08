import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i, j, cnt;
		int[] arr = new int[t];
		char[][] ch = new char[2][];
		for(i=0; i<t; i++) {
			cnt=0;
			ch[0]=sc.next().toCharArray();
			ch[1]=sc.next().toCharArray();
			for(j=0; j<ch[0].length; j++) {
				if(ch[0][j]!=ch[1][j])
					cnt++;
			}
			arr[i]=cnt;
		}
		for(i=0; i<t; i++)
			System.out.println("Hamming distance is "+arr[i]+".");
	}
}
