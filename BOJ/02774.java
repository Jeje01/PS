import java.util.Scanner;

public class Main {
	public static void getNum(String a) {
		int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		char[] ch = a.toCharArray();
		int i, cnt=0;
		for(i=0; i<ch.length; i++) {
			arr[ch[i]-48]++;
		}
		for(i=0; i<arr.length; i++) {
			if(arr[i]!=0) cnt++;
		}
		System.out.println(cnt);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i;
		String[] str = new String[t];
		for(i=0; i<t; i++) {
			str[i]= sc.next();
		}
		for(i=0; i<t; i++) {
			getNum(str[i]);
		}	
	}
}
