abstract class Unit2 {
    void move(int x,int y){};
    void stop(){System.out.println("멈춥니다.");};
}
interface Fightable{
    public void move(int x, int y);
    public void attack(Fightable f);

}

class Fighter extends Unit2 implements Fightable{
    public void move(int x, int y){
        System.out.println("x : " + x +"y : "+y);
    }
    public void attack(Fightable f){
        System.out.println(f+"을/를 공격합니다.");
    }
        }

public class ex7_31 {
    public static void main(String args[]){
        Fightable f = new Fighter();
        f.attack(f);
        f.move(10,11);
       // f.stop();
    }
}
