package date0531;

import java.util.Scanner;

public class Assi01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 5;//当前系统一共能够注册n个用户
        int exist = 0;//当前系统已经注册了几个用户
        int index = -1;//当前登录的用户索引
        int[] accounts = new int[n];//用户账户数组
        int[] passwords = new int[n];//用户密码数组

        //1、登录 2、注册 3、取款 4、存款 5、查询余额 6、退出
        int operation ;//当前操作

        while (exist == 0){
            System.out.print("\n1、登录 2、注册 3、取款 4、存款 5、查询余额\n" +
                    "请输入您要执行的操作：");
            operation = scanner.nextInt();
            if (operation == 2){
                System.out.print("请输入您的账号：");
                accounts[0] = scanner.nextInt();
                System.out.print("请输入您的密码：");
                passwords[0] = scanner.nextInt();
                exist++;
                System.out.println("注册成功！");
            }else {
                System.out.println("该系统还未存储任何用户数据，请先注册再执行操作！");
            }
        }
        while (true){
            System.out.print("\n1、登录 2、注册 3、取款 4、存款 5、查询余额 6、退出登录 7、退出系统\n" +
                    "请输入您要执行的操作：");
            operation = scanner.nextInt();
            if (operation == 1){
                if (index != -1){
                    System.out.println("您已经处于登录状态！不可以重复登录！");
                }else{
                    System.out.print("请输入您的账号：");
                    int account = scanner.nextInt();
                    System.out.print("请输入您的密码：");
                    int password = scanner.nextInt();

                    for (int i = 0; i < exist; i++){
                        if (account == accounts[i]){
                            index = i;
                        }
                    }
                    if (index == -1){
                        System.out.println("您输入的账号错误！");
                    }else{
                        if (password != passwords[index]){
                            System.out.println("您输入的密码错误！");
                            index = -1;
                        }else{
                            System.out.println("登录成功");
                        }
                    }
                }
            }else if (operation == 2){
                if (exist == n){
                    System.out.println("该系统人数已满！");
                }else{
                    System.out.print("请输入您的账号：");
                    accounts[exist] = scanner.nextInt();
                    System.out.print("请输入您的密码：");
                    passwords[exist] = scanner.nextInt();
                    exist++;
                    System.out.println("注册成功！");
                }
            }else if (operation == 3){
                if (index != -1){
                    System.out.println("账号" + accounts[index] +"，取款");
                }else{
                    System.out.println("请您先登录");
                }
            }else if (operation == 4){
                if (index != -1){
                    System.out.println("账号" + accounts[index] +"，存款");
                }else{
                    System.out.println("请您先登录");
                }
            }else if (operation == 5){
                if (index != -1){
                    System.out.println("账号" + accounts[index] +"，查询余额");
                }else{
                    System.out.println("请您先登录");
                }
            }else if (operation == 6){
                if (index != -1){
                    System.out.println("退出账号" + accounts[index] + "成功！");
                    index = -1;
                }else{
                    System.out.println("请您先登录");
                }
            }else if (operation == 7){
                break;
            }else{
                System.out.println("请输入正确的操作指令！");
            }
        }
        System.out.println("欢迎下次使用！");
    }

}
