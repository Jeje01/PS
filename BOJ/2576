import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int i, min=0, tmp, sum=0, check=0;
		for(i=0; i<7; i++) {
			tmp = sc.nextInt();
			if(tmp%2!=0) {
				if(check==0) {
					min=tmp;
					check=1;
				}
				else
					min = min<tmp ? min : tmp;
				sum+=tmp;
			}
		}
		if(check==0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
