import java.util.Scanner;

//双色球抽奖模拟系统
public class UnionLotto {
    public static boolean ifDuplicate(int[] arr, int num) {
        for (int a : arr) {
            if (a == num) {
                return true;
            }
        }
        return false;
    }

    //读取用户输入
    public static int[] userInputNumbers() {
        int[] inputNumbers = new int[7];
        Scanner s = new Scanner(System.in);
        int count = 0;
        while (true) {
            System.out.print("请输入第" + (count + 1) + "个数: ");
            if (!s.hasNextInt()) {
                s.next();
                System.out.println("请输入一个数字！！！");
                continue;
            }
            int temp = s.nextInt();
            if (count < 6 && (temp < 1 || temp > 33)) {
                System.out.println("请输入1-33中的某个数字");
                continue;
            } else if (count == 6 && (temp < 1 || temp > 16)) {
                System.out.println("请输入1-16中的某个数字");
                continue;
            } else if (count < 6 && ifDuplicate(inputNumbers, temp)) {
                System.out.println("请输入与前面输入不同的数字");
                continue;
            }
            inputNumbers[count++] = temp;
            if (count == 7) {
                break;
            }
        }
        s.close();
        return inputNumbers;
    }

    //判断是否获奖
    public static int winPrizeMoney(int[] userInputNumbers, int[] red, int blue) {
        int redCount = 0;
        boolean blueCount;
        for (int i = 0; i < 6; i++) {
            if (ifDuplicate(red, userInputNumbers[i])) {
                redCount++;
            }
        }
        blueCount = userInputNumbers[6] == blue;
        if (redCount == 6 && blueCount) {
            return 10000000;
        } else if (redCount == 6) {
            return 5000000;
        } else if (redCount == 5 && blueCount) {
            return 3000000;
        } else if (redCount == 5 || (redCount == 4 && blueCount)) {
            return 200;
        } else if (redCount <= 4 && redCount >= 2 && blueCount) {
            return 20;
        } else if (blueCount) {
            return 5;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] red = {12, 21, 5, 11, 26, 31};
        int blue = 15;
        System.out.println(winPrizeMoney(userInputNumbers(), red, blue));
    }
}
