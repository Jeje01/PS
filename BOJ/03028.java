import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] pos= {1, 0, 0};
		char[] ch = sc.next().toCharArray();
		int i, tmp;
		for(i=0; i<ch.length; i++) {
			switch(ch[i]) {
			case 'A':
				tmp=pos[1];
				pos[1]=pos[0];
				pos[0]=tmp;
				break;
			case 'B':
				tmp=pos[2];
				pos[2]=pos[1];
				pos[1]=tmp;
				break;
			case 'C':
				tmp=pos[2];
				pos[2]=pos[0];
				pos[0]=tmp;
				break;
			}
		}
		if(pos[0]==1)
			System.out.println(1);
		else if(pos[1]==1)
			System.out.println(2);
		else
			System.out.println(3);
	}
}
