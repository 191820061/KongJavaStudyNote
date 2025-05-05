import java.util.Scanner;

public class Question {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        Scanner s = new Scanner(System.in);
        if (s.hasNextInt()){
            a = s.nextInt();
        }
        if (s.hasNextInt()){
            b = s.nextInt();
        }
        int count = 0;
        while (a>=b){
            a -=b;
            count++;
        }
        System.out.println("quotient is "+count);
        System.out.println("remainder is "+a);
    }
}
