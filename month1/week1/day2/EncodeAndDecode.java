public class EncodeAndDecode {
    //加密
    public static int encodeNum(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("请输入大于的数字");
        }
        int result = 0;
        while (num != 0) {
            result = result * 10 + (num % 10 + 5) % 10;
            num /= 10;
        }
        return result;
    }

    //解码
    public static int decodeNum(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("请输入大于0的数字");
        }
        int result = 0;
        while (num != 0) {
            result = result * 10 + (num % 10 + 5) % 10;
            num /= 10;
        }
        return result;
    }

    //测试
    public static void main(String[] args) {
        int num = 1983;
        int num2 = encodeNum(num);
        System.out.println(num2);
        System.out.println(decodeNum(num2));

    }
}
