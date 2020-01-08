import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] s = {0, 0, 0, 0, 0};
		int i, j, max=0, index=-1;
		for(i=0; i<5; i++)
			for(j=0; j<4; j++)
				s[i]+=sc.nextInt();
		for(i=0; i<5; i++) {
			if(max<s[i]) {
				max=s[i];
				index = i;
			}
		}
		Arrays.sort(s);
		if(s[4]!=s[3])
			System.out.println((index+1)+" "+s[4]);	
	}
}
