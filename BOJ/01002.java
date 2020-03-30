import java.util.Scanner;

public class Main {
    public static int getAns(int[] input){
        int answer, sum = (input[2] + input[5])*(input[2] + input[5]);
        int gap = (input[5] - input[2])*(input[5] - input[2]);
        if(input[0]==input[3] && input[1]==input[4]) {
            if(input[2] == input[5])
                return -1;
            else
                return 0;
        }
        double dis = Math.pow((input[3]-input[0]), 2)+Math.pow((input[4]-input[1]), 2);
        if(dis<sum) {
            if(dis == gap)
                answer = 1;
            else if(dis < gap)
                answer = 0;
            else
                answer = 2;
        }
        else if(dis==sum)
            answer = 1;
        else
            answer = 0;
        return answer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] arr = new int[t][6];
        int i, j;
        for(i=0; i<t; i++){
            for(j=0; j<6; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(i=0; i<t; i++){
            System.out.println(getAns(arr[i]));
        }
    }
}
