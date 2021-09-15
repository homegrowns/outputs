package DisplaysAndTests;

import person.Item.Bait;
import person.Item.DowningstressItem;
import person.Item.prayer;
import person.Item.fishingPole;
import person.fisher;

import java.util.Random;

public class PotionItemTest {
    public static void main(String[] args) {
        // Create Items

        DowningstressItem bred = new DowningstressItem(1, "빵", 40, 20);

        fishingPole veteran = new fishingPole(100, "중견낚시대", 12, 5);

        prayer pr = new prayer("gas", 4, 500, 50);

        Bait bait = new Bait(12, "지렁이", 10, 1);

        /*fisher fishman = new fisher(" ", 99999999, 40, 100, 100, 10, 120,
                0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1);
*/
/*

        System.out.println("========================");
        StressdownDisplay.StressAndGas(fishman);
        System.out.println("========================");
        // Let the character consume items
        StressdownDisplay.basicDetails(bred);
        System.out.println("========================");

        System.out.println("========================");// 감소 상태
        veteran.using(fishman);

        StressdownDisplay.StressAndGas(fishman);
        System.out.println("--------------------------------");


        System.out.println("--------------------------------");
        System.out.println("미끼좀쓰자");

        StressdownDisplay.detalis2(bait);
        bait.gainBait(fishman);
        StressdownDisplay.baitbait(fishman);

*/

        veteran.WeatherSoother();
    }
}