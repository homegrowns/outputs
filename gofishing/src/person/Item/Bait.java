package person.Item;

import person.fisher;

import java.util.ArrayList;

public class Bait extends Item implements Baitable  {

    protected int earnbait;

    public Bait(int categoryNum, String name, int price, int earnbait) {
        super();
        this.earnbait = earnbait;
        this.name = name;
        this.price = price;
        this.categoryNum = categoryNum;
    }

    public int GetBait() {return earnbait;}



    @Override
    public void gainBait(fisher fishb) {fishb.plusBait(earnbait);}

    public void market() {
        ArrayList<Bait> arrayList = new ArrayList<Bait>();

        Bait worm = new Bait(5, "지렁이", 5, 2);
        Bait pasteba = new Bait(6, "떡밥", 1, 1);
        Bait packofbait = new Bait(7,"미끼묶음",10,20);


        arrayList.add(worm);
        arrayList.add(pasteba);
        arrayList.add(packofbait);

        for (Bait item : arrayList) {
            System.out.println(String.format("[번호:%d, 내용:%s, 가격:%d, 미끼수증가%d] ", item.categoryNum, item.name, item.price, item.earnbait));
        }
    }

}
