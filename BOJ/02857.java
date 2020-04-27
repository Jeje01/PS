import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       ArrayList<Integer> list = new ArrayList<>();
       int i, j;
       for(i=0; i<5; i++){
            String s = sc.next();
            if(s.length()>=3){
                for(j=0; j<s.length()-2; j++){
                    if(s.substring(j, j+3).equals("FBI")) {
                        list.add(i + 1);
                        break;
                    }
                }
            }

       }
       if(list.size()==0)
           System.out.println("HE GOT AWAY!");
       else{
           for(i=0; i<list.size(); i++)
               System.out.print(list.get(i)+" ");
       }
    }
}
