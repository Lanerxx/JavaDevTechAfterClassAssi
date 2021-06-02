package date0602;

import java.util.Scanner;

public class Assi01 {
    public static void main(String[] args) {
        ATM();
    }
    public static void ATM(){
        Scanner scanner = new Scanner(System.in);
        int[][] users = new int[2][3];//0:账户  1:密码  2:余额
        boolean flag = true;
        System.out.println("————————欢迎使用ATM———————");
        int count = 0;//现有用户数量
        int index = -1;//当前用户
        int operation;
        int n;//存取款操作额
        while (flag){
            System.out.print(
                    "1、登录  2、注册  3、取钱  4、存钱  5、查询余额  6、转账  " +
                    "7、退出登录  8、退出系统\n" +
                    "请选择您要进行的操作:");
            operation = scanner.nextInt();
            switch (operation){
                case 1:
                    if (index != -1){
                        System.out.println("请勿重复登录");
                    }else {
                        if (count == 0){
                            System.out.println("请先注册再登录");
                        }else{
                            System.out.print("请输入您的账户：");
                            int account = scanner.nextInt();
                            System.out.print("请输入您的密码：");
                            int password = scanner.nextInt();
                            index = login(account, password, users);
                            if (index == -1){
                                System.out.println("您输入的账户和密码错误");
                            }else {
                                System.out.println("登录成功");
                            }
                        }
                    }
                    break;
                case 2:
                    if (index != -1){
                        System.out.println("请先退出登录，再进行注册");
                    }else{
                        if (count == users.length){
                            int[][] tempt = new int[users.length * 2][3];
                            for (int i = 0; i < users.length; i++){
                                for (int j = 0; j < users[i].length; j++){
                                    tempt[i][j] = users[i][j];
                                }
                            }
                            System.out.println("系统由：" + users.length + "扩容为：" + tempt.length);
                            users = tempt;
                        }
                        System.out.print("请输入您的账户：");
                        users[count][0] =  scanner.nextInt();
                        System.out.print("请输入您的密码：");
                        users[count][1] =  scanner.nextInt();
                        users[count][2] = 0;
                        System.out.print("注册成功，您的账户为" + users[count][0] + "，您的账户余额为0。");
                        count++;
                    }
                    break;
                case 3:
                    if (index == -1){
                        System.out.println("请先登录再操作");
                    }else {
                        System.out.print("请输入取款金额：");
                        n = scanner.nextInt();
                        if (n > users[index][2]) {
                            System.out.println("您的余额不足，取款失败");
                        } else {
                            users[index][2] -= n;
                            System.out.println("您取款：" + n + "，当前余额为：" + users[index][2]);
                        }
                    }
                    break;
                case 4:
                    if (index == -1){
                        System.out.println("请先登录再操作");
                    }else {
                        System.out.print("请输入存款金额：");
                        n = scanner.nextInt();
                        users[index][2] += n;
                        System.out.println("您存款：" + n + "，当前余额为：" + users[index][2]);
                    }
                    break;
                case 5:
                    if (index == -1){
                        System.out.println("请先登录再操作");
                    }else {
                        System.out.println("您的当前余额为：" + users[index][2]);
                    }
                    break;
                case 6:
                    if (index == -1){
                        System.out.println("请先登录再操作");
                    }else{
                        System.out.print("请输入对方账户：");
                        int account_other = scanner.nextInt();
                        System.out.println("请输入转账金额：");
                        n = scanner.nextInt();
                        int index_other = getAccountIndex(account_other, users);
                        if (index_other == -1){
                            System.out.println("您输入的账户不存在");
                        }else if (users[index][2] < n){
                            System.out.println("您的余额不足");
                        }else{
                            users[index_other][2] += n;
                            users[index][2] -= n;
                            System.out.println("您转账：" + n + "，当前余额为：" + users[index][2]);
                        }
                    }
                    break;
                case 7:
                    index = -1;
                    System.out.println("当前账号，退出成功");
                    break;
                case 8:
                    flag = false;
                    System.out.println("欢迎下次使用");
                    break;
                default:
                    System.out.println("请输入正确的操作");
            }
            System.out.println();
        }
    }
    public static int getAccountIndex(int account, int[][] users){
        int index = -1;
        for (int i = 0; i < users.length; i++){
            if (account == users[i][0]){
                index = i;
            }
        }
        return index;
    }
    public static int login(int account, int password, int[][] users){
        int index = -1;
        for (int i = 0; i < users.length; i++){
            if (account == users[i][0] && password == users[i][1]){
                index = i;
            }
        }
        return index;
    }
}
