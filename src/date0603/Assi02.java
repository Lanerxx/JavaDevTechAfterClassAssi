package date0603;

import java.util.Scanner;

public class Assi02 {
    public static void main(String[] args) {
        ATMPlus();
    }
    public static void ATMPlus(){
        Scanner scanner = new Scanner(System.in);
        int initCapacity = 2;//系统初始容量
        User[] users = new User[initCapacity];
        users = initUsers(users);
        int operation;//操作
        int existCount = 0;//现有用户数量
        int myIndex = -1;//当前用户索引
        boolean systemFlag = true;
        while (systemFlag){
            System.out.print("\n1、登录  2、注册  3、退卡\n" +
                    "请输入您要进行的操作：");
            operation = scanner.nextInt();
            switch (operation){
                case 1:
                    System.out.print("请输入您的账号：");
                    int accountLogin = scanner.nextInt();
                    System.out.print("请输入您的密码：");
                    int passwordLogin = scanner.nextInt();
                    myIndex = getLoginIndex(accountLogin, passwordLogin, users);
                    if (myIndex != -1){
                        System.out.println("登录成功");
                        boolean login = true;
                        while (login){
                            System.out.println("\n1、存款  2、取款  3、查询余额  4、转账  5、退出登录\n" +
                                    "请输入您要进行的操作：");
                            operation = scanner.nextInt();
                            switch (operation){
                                case 1:
                                    System.out.print("请输入存款金额：");
                                    users[myIndex].balance += scanner.nextInt();
                                    System.out.println("存款成功，您当前的余额是：" + users[myIndex].balance);
                                    break;
                                case 2:
                                    System.out.print("请输入取款金额：");
                                    int withdrawal = scanner.nextInt();
                                    if (withdrawal <= users[myIndex].balance){
                                        users[myIndex].balance -= withdrawal;
                                        System.out.println("取款成功，您当前的余额是：" + users[myIndex].balance);
                                    }else{
                                        System.out.println("余额不足，取款失败");
                                    }

                                    break;
                                case 3:
                                    System.out.println("您当前的余额是：" + users[myIndex].balance);
                                    break;
                                case 4:
                                    System.out.print("请输入您要转账的账户：");
                                    int accountOther = scanner.nextInt();
                                    if (accountOther != users[myIndex].account){
                                        int otherIndex = getAccountIndex(accountOther, users);
                                        if (otherIndex != -1){
                                            System.out.print("请输入您要转账的金额：");
                                            int money = scanner.nextInt();
                                            if (money <= users[myIndex].balance){
                                                users[myIndex].balance -= money;
                                                users[otherIndex].balance += money;
                                                System.out.println("转账成功，您当前的余额是：" + users[myIndex].balance);
                                            }else{
                                                System.out.println("余额不足，转账失败");
                                            }
                                        }else {
                                            System.out.println("您输入的账户不存在");
                                        }
                                    }else {
                                        System.out.println("不能给自己转账");
                                    }
                                    break;
                                case 5:
                                    login = false;
                                    myIndex = -1;
                                    break;
                                default:
                                    System.out.println("请输入正确的操作");
                            }

                        }
                    }else {
                        System.out.println("登录失败");
                    }
                    break;
                case 2:
                    if (existCount == users.length){
                        User[] template = new User[users.length * 2];
                        template = initUsers(template);
                        for (int i = 0; i < users.length; i++){
                            template[i] = users[i];
                        }
                        System.out.println("系统由" + users.length + "扩容为：" + template.length);
                        users = template;
                    }
                    System.out.print("请输入您的账号：");
                    users[existCount].account = scanner.nextInt();
                    System.out.print("请输入您的密码：");
                    users[existCount].password = scanner.nextInt();
                    users[existCount].balance = 0;
                    existCount++;
                    break;
                case 3:
                    systemFlag = false;
                    myIndex = -1;
                    break;
                default:
                    System.out.println("请输入正确的指令");
            }
        }
        System.out.println("欢迎下次使用");
    }

    public static User[] initUsers(User[] users){
        for (int i = 0; i < users.length; i++){
            users[i] = new User();
        }
        return users;
    }

    public static int getAccountIndex(int account, User[] users){
        int index = -1;
        for (int i = 0; i < users.length; i++){
            if (users[i].account == account){
                index = i;
                break;
            }
        }
        return index;
    }

    public static int getLoginIndex(int account, int password, User[] users){
        int index = -1;
        for (int i = 0; i < users.length; i++){
            if (users[i].account == account && users[i].password == password){
                index = i;
                break;
            }
        }
        return index;
    }

}
