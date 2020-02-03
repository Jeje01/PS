import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input = sc.nextLine().toCharArray();
		int i;
		//A 65 / Z 90 / a 97/ z 122
		for(i=0; i<input.length; i++) {
			if(input[i]>=65&&input[i]<=90) {
				if(input[i]+13>90)
					input[i]=(char)(input[i]-13);
				else
					input[i]=(char)(input[i]+13);
			}else if(input[i]>=97&&input[i]<=122) {
				if(input[i]+13>122)
					input[i]=(char)(input[i]-13);
				else
					input[i]=(char)(input[i]+13);
			}
		}
		System.out.println(String.valueOf(input));
	}	
}
