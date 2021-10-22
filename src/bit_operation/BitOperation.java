package bit_operation;

public class BitOperation {
    public static void main(String[] args) {
        int n = 15;
//        // 返回每一位的二进制值
//        for(int i=5; i>=0; i--) {
//            System.out.println(n >> i & 1);
//        }

        // 原码和反码和补码
        // 补码就是源码的负数表示 = ~(源码) + 1
        int a = 10;
        for(int i=4; i>=0; i--) {
            System.out.println(a >> i & 1);
        }
        System.out.println("=============");
        int c = -a;
        for(int i=4; i>=0; i--) {
            System.out.println(c >> i & 1);
        }
     }

}
