package person.Item;

import person.Gui.fishpic;
import person.fisher;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MutantFish extends fish {
public int legend;


    public MutantFish(int price, String name, int categoryNum,int legend) {
        super(price, name, categoryNum);
        this.legend=legend;
    }
    public int getLegend() {return legend;}

    Random rand = new Random();

    public void status() {
        MutantFish mu = new MutantFish(1000000, "TheMutant돌돔", 1000,666);
    }

    public void mutantfishLooking() {
        new fishpic();
    }

    public void MutantFishs() {
        ArrayList<MutantFish> mfishs = new ArrayList<MutantFish>();

        MutantFish mfis = new MutantFish(1000000, "TheMutant돌돔", 1000,666);
        MutantFish mfis1 = new MutantFish(0, "입두개 달린 전어", 14,0);
        MutantFish mfis2 = new MutantFish(0, "병든 물고기", 104,0);
        MutantFish mfis3 = new MutantFish(0, "소주병", 105,0);



        rand.setSeed(System.nanoTime());

        int min = 0, max = 3;
        Set<Integer> result = new TreeSet<>();
        while (result.size() != 1) {
            result.add(rand.nextInt(max - min + 1) + min);
        }
        for (int number : result) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("==========================================");
            System.out.println(" ");//로딩 쓰레드
            System.out.println("걸렸다!! ");
            System.out.println(" [" + mfishs.get(number).getName() + "]\t[가격: " + mfishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + mfishs.get(number).getCategoryNum() +"]\t[" +
                    mfishs.get(number).getLegend() + "]" );

            if (0==number) {
                mfishs.add(mfis);
                System.out.println("[돌연변이 돌돔을 잡았다!]");

            }
        }
    }
}