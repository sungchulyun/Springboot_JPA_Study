abstract class Unit{
    int x,y;
    abstract void move(int x,int y);
    void stop() {};
}
class Marine extends Unit {
    void move(int x, int y){
        System.out.println("Marine = [x="+ x+",y="+y+"]");}
    void stimPack(){System.out.println("마린이 스팀팩을 사용합니다!");};
    void stop(){System.out.println("Marine이 정지합니다.");};
}

class Tank extends Unit{
    void move(int x, int y){
        System.out.println("Tank = [x="+ x+",y="+y+"]");}
    void stop(){System.out.println("Tank가 정지합니다.");};
    void changeMode(){System.out.println("모드를 변경합니다.");}
    }
public class ex7_30 {
    public static void main(String args[]){
        Unit[] group = new Unit[3];
        group[0] = new Marine();
        group[1] = new Tank();
        group[0].move(5,4);
        group[0].stop();
    }

}
