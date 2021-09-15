package person.Item;

import person.Gui.fishpic;

import person.Weather.PoisonedWeather;
import person.Weather.weatherMethod;
import person.fisher;

import java.util.ArrayList;
import java.util.Random;

public class fishingPole extends Item implements Baitable, Consumable{
    protected int equi;
    String Legend;
    public int stressdowning;


    public fishingPole(int categoryNum, String name, int price, int stressdowning ) {
        super();
        this.stressdowning = stressdowning;
        this.name = name;
        this.price = price;
        this.categoryNum = categoryNum;

    }
    public void stayingBait() {
        System.out.println("[주위 미끼활용]");
        System.out.println("[잡은 물고기를 이용해 미끼 생산]");


    }

    public void WeatherSoother() {
        System.out.println("!!");
        System.out.println("날씨안정화시도!");
        for (int u=0; u<2; u++) {

            System.out.println("                                                                                    ");
            System.out.println("                                                        [하늘에 기도중..]");
            System.out.println("                                                                             ");
            System.out.println("                                                                             ");
            try {
                Thread.sleep(900);
            } catch (Exception e) {
            }
            if (u == 4 ) {
                System.out.println("[날씨 기우는중]");
            }
        }

    }

    Random rand = new Random();
    public String getName() {return name;}


    public int getDowmstress() {
        return stressdowning;
    }
    public void marketforpole() {
    ArrayList<fishingPole> fishingpoles = new ArrayList<fishingPole>();

        fishingPole basic = new fishingPole(0,"기본낚시대",10, 5); // 스트레스 다운스킬
        fishingPole veteran = new fishingPole(1, "중견낚시대",20,10); // 1. 스트레스다운 2. 미끼유지
        fishingPole  highend = new fishingPole(2, "고급낚시대", 50,30); //1. 스트레스다운 2. 미끼무한 3. 개스 1분간 무한
        fishingPole  the = new fishingPole(3, "TheLegend", 1000,100);  // 1.돌연변이 부르기 2. 날씨 안정화 3. 개스 1분 무한

        fishingpoles.add(basic);
        fishingpoles.add(veteran);
        fishingpoles.add(highend);
        fishingpoles.add(the);

        for(fishingPole item :fishingpoles) {
        System.out.println(String.format("[번호:%d, 내용:%s, 가격:%d, 스트레스감소%d]", item.categoryNum, item.name,item.price,item.stressdowning ));

    }
}



    @Override
    public void gainBait(fisher fishb) {

    }



    @Override
    public void using(fisher fi) {
        fi.downStress(stressdowning); // 낚시꾼 fi가 downStress 메소드발동
    }



}
