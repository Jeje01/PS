import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] unit = {300, 60, 10};
		int[] answer = new int[unit.length];
		int i, cnt=0, tmp;
		for(i=0; i<unit.length; i++) {
			if(t>=unit[i]) {
				answer[i]=t/unit[i];
				t-=answer[i]*unit[i];
			}
			else
				answer[i]=0;
		}
		if(t!=0)
			System.out.println(-1);
		else {
			for(i=0; i<answer.length; i++)
				System.out.print(answer[i]+" ");
		}
	}	
}
