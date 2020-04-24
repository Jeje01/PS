import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int value = n, cnt=0;
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(n, 0);
        while(true){
            value = value*n%p; cnt++;
            if(h.containsKey(value)) {
                cnt = cnt - h.get(value);
                break;
            } else{
                h.put(value, cnt);
            }
        }
        System.out.println(cnt);
    }
}
