package Basic_Algorithm.block_search;

public class test {
    public static void main(String[] args) {
        int i = -5; // 101 - 010 + 1 - 011
        while(i!=-1) {
            System.out.println(i & 1);
            i>>=1;
        }
        System.out.println(100%99);
    }
}
