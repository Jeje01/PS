import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i;
        ArrayList<Integer> list = new ArrayList<>();
        while(true) {
            double r = sc.nextInt();
            if(r==0) break;
            int w = sc.nextInt();
            int l = sc.nextInt();
            if(2*r>=Math.sqrt(w*w+l*l)) {
                list.add(1);
            }
            else {
                list.add(0);
            }
        }
        for(i=0; i<list.size(); i++){
            if(list.get(i)==0)
                System.out.println("Pizza "+(i+1)+" does not fit on the table.");
            else
                System.out.println("Pizza "+(i+1)+" fits on the table.");
        }
    }
}
