package date0525;

public class assi1 {
    public static void main(String[] args){
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
    }
}
