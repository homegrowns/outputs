package person;

import person.Gui.bossFish;
import person.Gui.fishpic;

public class MarketMan  {
String name;
    public MarketMan(String name) {
      this.name = name;
    }


    public void talk() {
        System.out.println("안녕하신가! 오늘 좋은 물품이 들어왓내!");
        System.out.println("기대해도 좋아!");
        System.out.println(" ");
        System.out.println("아그리고 큰고기를 잡으려면 정성이필요하지 하하");
        System.out.println("정성90이상 일수도 하하핫");

    }


public void buying() {
    System.out.println("[이 괴물고기는??]");
    new bossFish();
    System.out.println("[여기 현상금 가져가게]");
    System.out.println("+ 100000000)");
}




}
