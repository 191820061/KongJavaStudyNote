
//数组学习
public class ArrayStudy {
    //逆转数组
    public static void reverseArray(int[] a) {
        int left = 0;
        int right = a.length-1;
        while (left<right){
            int c = a[left];
            a[left]=a[right];
            a[right]=c;
            left++;
            right--;
        }
    }

    //求数组最大值
    public static int max(int[] arr) {
        int max = -100000000;
        for (int a : arr) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }

    //求和与平均值以及比平均值小的数的数量
    public static void sumAndCount(int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        int average = sum / arr.length;
        int count = 0;
        for (int a : arr) {
            if (a < average) {
                count++;
            }
        }
        System.out.println("数组和为" + sum + "平均值为" + average + "比平均值小的数有" + count + "个");
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 77};
        System.out.println(max(a));
        sumAndCount(a);
        reverseArray(a);
        for (int b:a){
            System.out.print(b+" ");
        }
    }
}
