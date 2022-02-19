abstract class Player{
    abstract void play(int pos);
    abstract void stop();
}

class AudioPlayer extends Player{
    void play(int pos){System.out.println(pos+"부터 재생됩니다.");};
    void stop(){System.out.println("정지합니다");};
}

public class Ex_7_30 {
    public static void main(String args[]){
        AudioPlayer ap = new AudioPlayer();
        ap.play(100);
        ap.stop();
    }
}
