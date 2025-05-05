import java.util.Scanner;

public class IsPrimeNum {
    public static boolean isPrime(int num){
        if (num==1){
            return false;
        }
        for (int i=2;i*i<=num;i++){
            if (num%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int num = 1;
        Scanner s = new Scanner(System.in);
        if (s.hasNextInt()) {
            num = s.nextInt();
        }else{
            System.exit(0);
        }
        if (isPrime(num)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
