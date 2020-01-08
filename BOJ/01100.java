import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[8][8];
		int i, j, cnt=0;
		for(i=0; i<8; i++) {
			arr[i]=sc.next().toCharArray();
		}
		for(i=0; i<8; i++) {
			for(j=0; j<8; j++) {
				if((i+j)%2==0 && arr[i][j]=='F')
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
