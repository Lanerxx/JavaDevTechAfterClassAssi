package date0525;

public class assi2 {
    public static void main(String[] args){
        double sum = 500;
        double shoes = 58;
        double clothes = 30;
        double bag = 55.8;
        double balance = sum - shoes - 3 * clothes - 5 * bag;
        System.out.println(balance >= 0 ? "余额：" + balance : "你买不起");
    }
}
