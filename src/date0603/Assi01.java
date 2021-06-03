package date0603;

import java.util.Scanner;

public class Assi01 {
    public static void main(String[] args) {
        ATM();
    }
    public static void ATM(){
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        user.account = 1001;
        user.password = 1001;
        user.balance = 500000;
        int operation;
        boolean flag = true;
        while (flag){
            System.out.print("1、存款  2、取款  3、查询余额  4、退出\n" +
                    "请输入操作：");
            operation = scanner.nextInt();
            switch (operation){
                case 1:
                    System.out.print("请输入存款金额：");
                    user.balance += scanner.nextInt();
                    System.out.println("存款成功，您当前的余额是：" + user.balance);
                    break;
                case 2:
                    System.out.print("请输入取款金额：");
                    int withdrawal = scanner.nextInt();
                    if (withdrawal <= user.balance){
                        user.balance -= withdrawal;
                        System.out.println("取款成功，您当前的余额是：" + user.balance);
                    }else {
                        System.out.println("余额不足，取款失败");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("请输入正确的操作");

            }
        }
        System.out.println("欢迎下次使用");
    }
}
