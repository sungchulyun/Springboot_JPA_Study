
class Product2 {
    int price;
    int bonusPoint;

    Product2(int price){
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }
    Product2()  {
    }
}

class Tv2 extends Product2 {
    Tv2() {
        super(100);
    }

    public String toString() {
        return "TV";
    }
}
class Computer2 extends Product2 {
    Computer2() {
        super(200);
    }

    public String toString() {
        return "Computer";
    }
}

class Audio2 extends Product2 {
    Audio2() {
        super(50);
    }

    public String toString() {
        return "Audio";
    }
}
class Buyer2 {
    int money = 1000;
    int bonusPoint = 0;
    Product2 Cart[] = new Product2[10];
    int i = 0;

    void buy(Product2 p) {
        if (money < p.price) {
            System.out.println("잔액이 부족하여 결제 불가");
            return;
        }
        money = money - p.price;
        bonusPoint += bonusPoint;
        Cart[i++] = p;
        System.out.println(p + "을/를 구입하셨습니다.");
    }

    void summary() {
        int sum = 0;
        String itemList = "";

        for (int i = 0; i<Cart.length; i++){
            if(Cart[i]==null) break;
            sum+= Cart[i].price;
            itemList += Cart[i]+",";
        }
        System.out.println("구입하신 물품의 총가격은 " + sum + "만원입니다.");
        System.out.println("구입하신 제품은 " + itemList + "입니다.");
    }
}
public class ex7_29 {
    public static void main(String args[]){
        Buyer2 b = new Buyer2();

        b.buy(new Tv2());
        b.buy(new Computer2());
        b.buy(new Audio2());
        b.summary();
    }
}

