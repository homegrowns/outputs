package person.Item;

import person.fisher;

import java.util.ArrayList;

public class prayer extends Item implements Consumable {
  public int 정성Points;







   public prayer(String name, int categoryNum, int price, int 정성Points) {
       super();
       this.정성Points = 정성Points;
       this.name = name;
       this.price = price;
       this.categoryNum = categoryNum;
   }

    public int getGasPoints() { return 정성Points;}

    @Override
    public void using(fisher fi) {
      fi.chargeGasPoints(정성Points);
    }

    public void market() {
        ArrayList<prayer> arrayList = new ArrayList<prayer>();

        prayer charm = new prayer( "정성부적", 11, 100,50);
        prayer pray = new prayer("제사지내기" , 12, 10, 10);

        arrayList.add(charm);
        arrayList.add(pray);

        for (prayer item : arrayList) {
            System.out.println(String.format("[번호:%d, 내용:%s, 가격:%d, 정성도%d] ", item.categoryNum, item.name, item.price, item.정성Points));
        }
    }

}
