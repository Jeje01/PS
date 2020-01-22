import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		int m = sc.nextInt();
		int i, total=d;
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(i=0; i<m-1; i++)
			total+=month[i];
		switch(total%7){
		case 0:
			System.out.println("Wednesday");
			break;
		case 1:
			System.out.println("Thursday");
			break;
		case 2:
			System.out.println("Friday");
			break;
		case 3:
			System.out.println("Saturday");
			break;
		case 4:
			System.out.println("Sunday");
			break;
		case 5:
			System.out.println("Monday");
			break;
		case 6:
			System.out.println("Tuesday");
			break;
		}
	}	
}
