import java.util.HashMap;
import java.util.HashSet;

public class TestClass {

    public static void main(String[] args) {
        //写一段代码，实现以下功能：九九乘法表
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }


    }

}