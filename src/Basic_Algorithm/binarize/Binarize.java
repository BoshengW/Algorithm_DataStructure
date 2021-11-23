package Basic_Algorithm.binarize;

public class Binarize {
    public static void main(String[] args) {
        System.out.println(1<<5); // left shift 5 bit 100000 [0,11111]
        for(int i=0; i<(1<<5); i++) {
            // 遍历 [0,11111]
            for(int j=0; j<5; j++) {
                // 遍历i的每一位，如果是1就返回
                if((i&(1<<j))!=0) System.out.println(j);
            }
        }
    }
}
