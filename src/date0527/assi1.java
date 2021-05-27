package date0527;

import java.util.Scanner;

public class assi1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个byte类型整数：");
        byte b = scanner.nextByte();
        System.out.print("请输入一个short类型正式：");
        short s = scanner.nextShort();
        System.out.print("请输入一个int类型整数：");
        int i = scanner.nextInt();
        System.out.print("请输入一个long类型整数：");
        long l = scanner.nextLong();
        System.out.print("请输入一个float类型浮点数数：");
        float f = scanner.nextFloat();
        System.out.print("请输入一个double类型浮点数：");
        double d = scanner.nextDouble();
        System.out.print("请输入一个char字符：");
        char  c = scanner.next().charAt(0);
        System.out.print("请输入一个String字符串：");
        String str = scanner.next();
        System.out.print("请输入一个boolean类型数值：");
        boolean bl = scanner.nextBoolean();
        System.out.println("您输入的byte类型整数为：" + b);
        System.out.println("您输入的short类型正式为：" + s);
        System.out.println("您输入的int类型整数为：" + i);
        System.out.println("您输入的long类型整数为：" + l);
        System.out.println("您输入的float类型浮点数数为：" + f);
        System.out.println("您输入的double类型浮点数为：" + d);
        System.out.println("您输入的char字符为：" + c);
        System.out.println("您输入的String字符串为：" + str);
        System.out.println("您输入的boolean类型数值为：" + bl);
    }
}
