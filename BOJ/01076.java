import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long answer = 0;
        String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        String[] input = new String[3];
        int[] num = new int[3];
        int i, j;
        for(i=0; i<input.length; i++){
            input[i] = sc.next();
        }
        for(i=0; i<3; i++) {
            for (j = 0; j < colors.length; j++) {
                if(input[i].equals(colors[j])){
                    num[i] = j;
                }
            }
        }
        answer = (long)((num[0]*10 + num[1])*Math.pow(10, num[2]));
        System.out.println(answer);
    }
}
