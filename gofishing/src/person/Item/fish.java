package person.Item;

import java.util.ArrayList;

public class fish extends Item {


  public fish(int price, String name, int categoryNum) {
      this.name = name;
      this.price=price;
      this.categoryNum = categoryNum;
  }
   public String getName() {return name;}
   public int getCategoryNum( ) {return categoryNum;}

   public void kindsFish() {
       ArrayList<fish> fishs = new ArrayList<fish>();

       fish fis = new fish(10, "고등어", 13);
       fish fis1 = new fish(25, "전어", 14);
       fish fis2 = new fish(0, "병", 104);
       fish fis3 = new fish(0, "소주병", 105);
       fish fis4 = new fish(100, "100원", 106); //
       fish fis5 = new fish(0, "쓰레기덩어리", 103);
       fish fis6 = new fish(40, "돌돔", 16);
       fish fis7 = new fish(50, "문어", 17); //
       fish fis8 = new fish(0, "바다 쓰레기", 100);
       fish fis9 = new fish(0, "새끼복어", 101);
       fish fis10 = new fish(0, "쓰레기봉지", 102);
       fish fis11 = new fish(30, "갈치", 15);  ///
       fish fis12 = new fish(0, "참이슬 소주병", 105);
       fish fis13 = new fish(0, "맥주병", 105);
       fish fis14 = new fish(100000, "다랑어", 18);
       fish fis15 = new fish(1000000, "상어", 20);

       fishs.add(fis);
       fishs.add(fis1);
       fishs.add(fis2);
       fishs.add(fis3);
       fishs.add(fis4);
       fishs.add(fis5);
       fishs.add(fis6);
       fishs.add(fis7);
       fishs.add(fis8);
       fishs.add(fis9);
       fishs.add(fis10);
       fishs.add(fis11);
       fishs.add(fis12);
       fishs.add(fis13);
       fishs.add(fis14);
       fishs.add(fis15);

       for(fish item :fishs) {
           System.out.println(String.format("[번호:%d, 내용:%s, 가격:%d,]", item.categoryNum, item.name,item.price));

       }


   }


   public void fishishowing() {


   }
}
