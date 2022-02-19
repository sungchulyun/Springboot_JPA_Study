class AAA {
    int i = 100;

    class BBB {
        void method() {

            ///         AAA aaa = new AAA();
            ///        System.out.println(aaa.i);
                System.out.println(i);
        }
    }
}

class CCC {}


public class ex7_33 {
    public static void main(String args[]) {
        AAA bbb = new AAA();
    }
}
