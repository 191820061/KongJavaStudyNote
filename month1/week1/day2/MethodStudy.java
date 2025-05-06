public class MethodStudy {
    //数组拷贝
    public static int[] copyArray(int[] a, int from, int length) {
        if (a==null){
            throw new IllegalArgumentException("数组为空");
        }
        if (from<0||from>=a.length||from+length>a.length){
            throw new IllegalArgumentException("访问超出数组范围");
        }
        int[] newArray = new int[length];
        int pos = 0;
        for (int i=from;i<from+length;i++){
            newArray[pos++]=a[i];
        }
        return newArray;
    }
    //数组打印
    public static void printArray(int[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]);
            if (i!=a.length-1){
                System.out.print(" ");
            }
        }
    }
    //测试
    public static void main(String[] args) {
        int[] array = new int[]{4,5,1,2,3,8,10};
        int[] newArray = copyArray(array,2,5);
        printArray(newArray);
    }
}
