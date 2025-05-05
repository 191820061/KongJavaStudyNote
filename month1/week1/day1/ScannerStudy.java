import java.util.Scanner;

public class ScannerStudy {
    public static void main(String[] args){
        Scanner i = new Scanner(System.in);
        while (i.hasNextInt()){
            int inputNum = i.nextInt();
            switch (inputNum){
                case 1:System.out.println("开始");break;
                case 0:System.out.println("退出");break;
                default:System.out.println("输出错误");
            }
        }
        System.out.println("程序运行结束");
    }
}
