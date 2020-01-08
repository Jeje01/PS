import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		char[] ch = (sc.next()).toCharArray();
		int i;
		int[] ap = new int[26];
		for(i=0; i<26; i++)
			ap[i]=0;
		for(i=0; i<ch.length; i++)
			ap[ch[i]-'a']++;
		for(i=0; i<26; i++)
			System.out.print(ap[i]+" ");
	}
}
