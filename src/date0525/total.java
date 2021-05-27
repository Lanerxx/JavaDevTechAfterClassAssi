package date0525;

public class total {
    public static void main(String[] args){
        System.out.println("作业1：");
        char a = 'a';
        char b = 'b';
        char c = 'c';
        char d = 'd';
        char tempt = a;
        a = d;
        d = tempt;
        tempt = b;
        b = c;
        c = tempt;
        System.out.println("a:" + a + ",b:" + b + ",c:" + c + ",d:" + d);
        System.out.println();

        System.out.println("作业2：");
        double sum = 500;
        double shoes = 58;
        double clothes = 30;
        double bag = 55.8;
        double balance = sum - shoes - 3 * clothes - 5 * bag;
        System.out.println(balance >= 0 ? "余额：" + balance : "你买不起");
        System.out.println();

        System.out.println("作业3：");
        int day = 10;
        int h = 24;
        int min = 60;
        int s = 60;
        System.out.println(day + "天共有" + day * h + "小时" + day * h * min + "分钟"
                + day * h * min * s +"秒");
    }
}
