import java.util.Scanner;

public class PalindromeNum {
    public static int reverse(int num){
        int reverseNum = 0;
        while (num!=0){
            reverseNum = reverseNum*10+num%10;
            num/=10;
        }
        return reverseNum;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = 0;
        if (s.hasNextInt()){
            num = s.nextInt();
        }else{
            System.exit(0);
        }
        int reverseNum = reverse(num);
        if (num==reverseNum){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
