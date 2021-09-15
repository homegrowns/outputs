package person.Item;

import person.fisher;

import java.util.ArrayList;

// can be food (bread, water) stuff like that
public class DowningstressItem extends Item implements Consumable {

   public int stressdowning;

    public DowningstressItem(int categoryNum, String name, int price, int stressdowning) {
        super();
        this.stressdowning = stressdowning;
        this.name = name;
        this.price = price;
        this.categoryNum = categoryNum;
    }

    public int getDowmstress() {
        return stressdowning;
    }


    @Override
    public void using(fisher fi) {
    fi.downStress(stressdowning); // 낚시꾼 fi가 downStress 메소드발동
    }

    public void market() {
        ArrayList<DowningstressItem> food = new ArrayList<DowningstressItem>();

        DowningstressItem bred = new DowningstressItem(1, "빵", 5, 5);
        DowningstressItem driedBred = new DowningstressItem(2, "건빵", 2, 2);
        DowningstressItem brew = new DowningstressItem(3, "과일주와 스테이크", 20, 20);
        DowningstressItem orange = new DowningstressItem(4, "과일화채", 15, 15);

        food.add(bred);
        food.add(driedBred);
        food.add(brew);
        food.add(orange);

        for(DowningstressItem item:food) {
            System.out.println(String.format("[번호:%d, 내용:%s, 가격:%d, 스트레스감소%d]", item.categoryNum, item.name,item.price,item.stressdowning ));

        }


}
}