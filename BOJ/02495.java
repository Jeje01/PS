import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = new String[3];
		int i, j, cnt, max;
		for(i=0; i<3; i++)
			str[i]=sc.next();
		for(i=0; i<3; i++) {
			max=0; cnt=1;
			for(j=0; j<7; j++) {
				if(str[i].charAt(j)==str[i].charAt(j+1))
					cnt++;
				else {
					max = max<cnt ? cnt : max;
					cnt=1;
				}
			}
			max = max<cnt ? cnt : max;
			System.out.println(max);
		}
	}
}
