class A {
    public void method(I i){
        i.method();
    }
}
interface I {
    public void method();

}

class B implements I {
    public void method(){
        System.out.println("B의 메소드");
    }
}

class C implements I {
    public void method(){
        System.out.println("C의 메소드");
    }
}

public class ex7_32 {
    public static void main(String args[]){
    A a = new A();    a.method(new B());
    }
}
