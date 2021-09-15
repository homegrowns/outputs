package person;

// import DisplaysAndTests.StressdownDisplay;

import DisplaysAndTests.StressdownDisplay;

import person.Item.*;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

import static java.rmi.server.LogStream.log;


public class fisher extends Thread implements Statusable {

    int money;
    public int stress;
    int stressMax;
    public int 정성;
    public int amoutOfbait;
    int baitMax;
    String name;


    int 고등어;
    int 전어;
    int 갈치;
    int 돌돔;
    int 문어;
    int 다랑어;
    int 상어;

    int 기본낚시대;
    int 중견낚시대;
    int 고급낚시대;
    int TheLegend;


    public fisher(String name, int money, int stress, int stressMax, int 정성, int amoutOfbait, int baitMax,
                  int 고등어, int 전어, int 갈치, int 돌돔, int 문어, int 기본낚시대, int 중견낚시대, int 고급낚시대, int 다랑어, int 상어, int TheLegend) {


        this.name = name;
        this.stress = stress;
        this.stressMax = stressMax;
        this.money = money;
        this.정성 = 정성;
        this.amoutOfbait = amoutOfbait;
        this.baitMax = baitMax;
        this.고등어 = 고등어;
        this.전어 = 전어;
        this.갈치 = 갈치;
        this.돌돔 = 돌돔;
        this.문어 = 문어;
        this.상어 = 상어;
        this.다랑어 = 다랑어;
        this.기본낚시대 = 기본낚시대;
        this.중견낚시대 = 중견낚시대;
        this.고급낚시대 = 고급낚시대;
        this.TheLegend = TheLegend;

    }

    public fisher(java.lang.String s, int money, int stress, int stressMax, int 정성, int amoutOfbait, int baitMax, int 고등어, int 전어, int 갈치, int 돌돔, int 문어, int 기본낚시대, int 중견낚시대, int 고급낚시대, int 다랑어, int 상어, int theLegend) {
    }


    public int getStress() {
        return stress;
    }

    public int get정성Points() {
        return 정성;
    }

    public String getname() {
        return name;
    }

    public int getStessMaxMax() {
        return stressMax;
    }

    public int getAmoutOfbait() {
        return amoutOfbait;
    }

    public int getBaitMax() {
        return baitMax;
    }


    public void downStress(int stressdowning) { /// 식당 food
        if (this.stress - stressdowning <= 0) {
            this.stress = 0;
        } else if (money > 0 & stressdowning == 5) {
            money -= 5;
            this.stress -= stressdowning;
            System.out.println("[-5 money]");
        } else if (money > 0 & stressdowning == 2) {
            money -= 2;
            this.stress -= stressdowning;
            System.out.println("[-2 money]");
        } else if (money > 0 & stressdowning == 20) {
            money -= 20;
            this.stress -= stressdowning;
            System.out.println("[-20 money]");
        } else if (money > 0 & stressdowning == 15) {
            money -= 15;
            this.stress -= stressdowning;
            System.out.println("[-15 money]");
        }
    }

    public void showingFpole() {
        System.out.println("============================================================================================================================");
        System.out.println(" [0. 기본낚시대 " + this.기본낚시대 + "개] " + "[1. 중견낚시대 " + this.중견낚시대 + "개] " + "[2. 고급낚시대 " + this.고급낚시대 + "개] " + "[3. this is TheLegend " + this.TheLegend + "개] " + "]");
        System.out.println("============================================================================================================================");
    }

    public void equip(int stressdowning) {
        if (this.stress - stressdowning <= 0) {
            this.stress = 0;
        } else if (기본낚시대 == 1 && stressdowning == 5) {
            this.stress -= stressdowning;
            System.out.println("[스킬발동]");
            System.out.println("기본낚시대사용 [낚시대 사용 성공시 스트레스 -5감소]");

            this.stress -= stressdowning;
        } else if (stressdowning == 10 && 중견낚시대 == 1) {
            this.stress -= stressdowning;
            System.out.println("[스킬발동]");
            System.out.println("기본낚시대사용 [낚시대 사용 성공시 스트레스 -10감소]");
        } else if (stressdowning == 30 && 고급낚시대 == 1) {
            this.stress -= stressdowning;
            System.out.println("[스킬발동]");
            System.out.println("기본낚시대사용 [낚시대 사용 성공시 스트레스 -30감소]");
        } else if (stressdowning == 100 && TheLegend == 1) {
            this.stress -= stressdowning;
            System.out.println("====================");
            System.out.println("[TheLegend Ativated]");
            System.out.println("====================");
            System.out.println("[낚시대 사용 성공 마다 스트레스 -100감소]");
        }
    }

    public void chargeGasPoints(int gasPoints) {
        if (money > 0 & gasPoints == 150) {
            money -= 100;
            this.정성 += gasPoints;
        } else if (money > 0 & gasPoints == 20) {
            money -= 10;
            this.정성 += gasPoints;
        }

    }

    public void plusBait(int earnbait) {
        if (this.amoutOfbait + earnbait > baitMax) {
            this.amoutOfbait = baitMax;
        } else if (money > 0 & earnbait == 1) {
            money -= 1;
            this.amoutOfbait += earnbait;
        } else if (money > 0 & earnbait == 2) {
            money -= 5;
            this.amoutOfbait += earnbait;
        } else if (money > 0 & earnbait == 20) {
            money -= 10;
            this.amoutOfbait += earnbait;
        }
    }

    public void fishing(int earnbait) {
        if (earnbait == 1) {
            amoutOfbait -= 1;
            stress += 2;
            System.out.println("미끼1 소모 , 스트레스 2 얻음");
            System.out.println("    *      ***");
            System.out.println("   ***  *********");
            System.out.println("  ******************");
            System.out.println("   ***  *********");
            System.out.println("    *      ***");
        } else if (earnbait == 2) {
            amoutOfbait -= 2;
            stress += 3; // 지렁이 = 문어 돌돔
            System.out.println("미끼2 소모 , 스트레스 3 얻음");
            System.out.println("    *      ***");
            System.out.println(" *  ***  *********&");
            System.out.println("*********************&");
            System.out.println(" *  ***  *********&");
            System.out.println("    *      ***");

        }
    }


    public void sleep() {
        stress -= 40; // 혈압 낯추기
        money -= 50;

        System.out.println("                )\n" +
                "               (\n" +
                "                )\n" +
                "       ******* []\n" +
                "     ***********]\n" +
                "   ***************   \n" +
                "  *****************\n" +
                "    ^^^^^^^^^^^^^    \n" +
                "    ^^^   ^^^^^^^\n" +
                "~~~ ^^^   ^^^^^^^ ~~~~~~~~~\n" +
                "~~~ ^^^^^^^^^^^^^ ~~~~~~~~~~~\n" +
                "~~~ ^^^^^^^^^^^^^~~~~~~~~~~~~ \n" +
                "~~  ^^^^^^^^^^^^^~~~~~~~~~~~~~~~~");
        System.out.println("[ 공짜는없다 돈 -50 소모 ]");
        System.out.println("zzZZ");
        System.out.println("-충분한 휴식으로 스트레스를 경감시키다- ");
    }


    public void die() {
        System.out.println("  ^^    +");
        System.out.println(" ^^     +        ^^");
        System.out.println("    +++++++++          ^^");
        System.out.println("        +   ^^");
        System.out.println("        +        ");
        System.out.println("        +      ");
        System.out.println("  ~~~~~~~~~~~~~");
        System.out.println(" ~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~");
        System.out.println("     ~R.I.P~");


    }

    public void arriveinHurry() {
        System.out.println("=================");
        System.out.println("[급속 회항!]");
        System.out.println("=================");
        System.out.println("         *==== - ~~~~");
        System.out.println("   !   **=======-- ~~~~");
        System.out.println("    !   **==== - ~~~~    ");
        System.out.println("    !   **              ");
        System.out.println("     ******************* ㅡㅡㅡ");
        System.out.println("      *****************  ㅡㅡㅡ");
        System.out.println("~~~~~~~ ************* ~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }


    public void arrive() {

        System.out.println("=================");
        System.out.println("[회항중]");
        System.out.println("=================");
        System.out.println(" ");
        System.out.println("        *==");
        System.out.println("       **====");
        System.out.println("       **==    0______");
        System.out.println("       **      ^       )");
        System.out.println(" *******************  (");
        System.out.println("  *****************    )");
        System.out.println("    ************* ");
        System.out.println("오늘은 얼마나 잡았나...");


    }


    public void depart() {   // 쓰레드

        System.out.println("빛을 값아야해!");
        System.out.println("출발하자!");
        System.out.println("-항구 선적 및 연료비용발생-");
        money -= 30;
        정성 -= 10;
        System.out.println("돈 -30 , 정성 -10");
        System.out.println("    ");
        System.out.println("    ____() ");
        System.out.println("  (    0000000 ~");
        System.out.println("   )  ~ 00000");
        System.out.println("   (     000");
        System.out.println("~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~");


    }


    @Override
    public void lookatStatus() {
        System.out.println("===================================================================================================================================");
        System.out.println("[이름: " + this.name + "]");
        System.out.println("[$돈: " + this.money + "]");
        System.out.println("[!!: " + this.stress + "/ " + this.stressMax + "]");
        System.out.println("[미끼: " + this.amoutOfbait + "/ " + this.baitMax + "]");
        System.out.println("[정성: " + this.정성 + " [날씨관련*]" + "]");
        System.out.println("[장비 = " + "[기본낚시대 " + this.기본낚시대 + "개] " + "[중견낚시대 " + this.중견낚시대 + "개] " + "[고급낚시대 " + this.고급낚시대 + "개] " + "[this is TheLegend " + this.TheLegend + "개] " + "]");
        System.out.println("===================================================================================================================================");
        System.out.println("[고등어: " + this.고등어 + "]");
        System.out.println("[전어: " + this.전어 + "]");
        System.out.println("[갈치: " + this.갈치 + "]");
        System.out.println("[돌돔: " + this.돌돔 + "]");
        System.out.println("[문어: " + this.문어 + "]");
        System.out.println("[다랑어: " + this.다랑어 + "]");
        System.out.println("[상어: " + this.상어 + "]");


    }

    public void itemGet(int number) {

        ArrayList<fish> fishs = new ArrayList<fish>();

        fish fis = new fish(10, "고등어", 13);
        fish fis1 = new fish(25, "전어", 14);
        fish fis2 = new fish(0, "병", 104);
        fish fis3 = new fish(0, "소주병", 105);
        fish fis4 = new fish(100, "100원", 106);
        fish fis5 = new fish(0, "쓰레기덩어리", 103);
        fish fis6 = new fish(40, "돌돔", 16);
        fish fis7 = new fish(50, "문어", 17);
        fish fis8 = new fish(0, "바다 쓰레기", 100);
        fish fis9 = new fish(0, "새끼복어", 101);
        fish fis10 = new fish(0, "쓰레기봉지", 102);
        fish fis11 = new fish(30, "갈치", 15);
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


        if (number == 0) {
            System.out.println("번호: " + fishs.get(number).getCategoryNum() + "이름: " + fishs.get(number).getName());
            고등어 += 1;
            System.out.println(" [고등어 획득 +1]");
        } else if (number == 1) {
            System.out.println("번호: " + fishs.get(number).getCategoryNum() + "이름: " + fishs.get(number).getName());
            전어 += 1;
            System.out.println("  [전어 획득 +1]");
        } else if (number == 4) {
            System.out.println("번호: " + fishs.get(number).getCategoryNum() + "이름: " + fishs.get(number).getName());
            money += 100;
            System.out.println("이게말이되나?");
            System.out.println("  [100원획득!]");
        } else if (number == 11) {
            System.out.println("번호: " + fishs.get(number).getCategoryNum() + "이름: " + fishs.get(number).getName());
            갈치 += 1;
            System.out.println("  [갈치 획득 +1]");
        } else if (number == 6) {
            System.out.print("번호: " + fishs.get(number).getCategoryNum() + "이름: " + fishs.get(number).getName());
            돌돔 += 1;
            System.out.println("  [돌돔 획득 +1]");
        } else if (number == 7) {
            System.out.println("번호: " + fishs.get(number).getCategoryNum() + "이름: " + fishs.get(number).getName());
            문어 += 1;
            System.out.println("  [문어 획득 +1]");
        } else if (number == 12) {
            System.out.println("번호: " + fishs.get(number).getCategoryNum() + "이름: " + fishs.get(number).getName());
            stress -= 20;
            System.out.println(" [참이슬 소주병 획득]");
            System.out.println("[조금 남아있다!]");
            System.out.println("[스트레스 -20]");
        } else if (number == 13) {
            System.out.println("번호: " + fishs.get(number).getCategoryNum() + "이름: " + fishs.get(number).getName());
            stress += 20;
            System.out.println(" [맥주병 획득]");
            System.out.println("[그냥 빈병]");
            System.out.println("[스트레스 +20]");
        } else if (number == 3) {
            System.out.println("번호: " + fishs.get(number).getCategoryNum() + "이름: " + fishs.get(number).getName());
            stress += 20;
            System.out.println(" [소주병 획득]");
            System.out.println("[그냥 빈병]");
            System.out.println("[스트레스 +20]");
        } else if (number == 14) {
            System.out.println("번호: " + fishs.get(number).getCategoryNum() + "이름: " + fishs.get(number).getName());
            다랑어 += 1;
            System.out.println(" [다랑어 획득]");
            System.out.println("월척!!");
        } else if (number == 15) {
            System.out.println("뭐지 이중압감은?");
            System.out.println("..........");
            System.out.println(" ");
            System.out.println("번호: " + fishs.get(number).getCategoryNum() + "이름: " + fishs.get(number).getName());
            상어 += 1;
            stress += 5;
            System.out.println(" [상어획득]");
            System.out.println("[힘겨운 싸움이였어!]");
            System.out.println("[스트레스 +5]");
        } else {
            System.out.println("번호: " + fishs.get(number).getCategoryNum() + "이름: " + fishs.get(number).getName());

            System.out.println("이런! 아까운 미끼가!!");
            System.out.println("쓰레기 때문에 스트레스 + 10");
            stress += 10;
        }
    }

    public void buying(int sb1) {

        ArrayList<fishingPole> fishingpoles = new ArrayList<fishingPole>();

        fishingPole basic = new fishingPole(0, "기본낚시대", 20, 5);
        fishingPole veteran = new fishingPole(1, "중견낚시대", 30, 10);
        fishingPole highend = new fishingPole(2, "고급낚시대", 50, 30);
        fishingPole the = new fishingPole(3, "TheLegend", 1000, 100);


        fishingpoles.add(basic);
        fishingpoles.add(veteran);
        fishingpoles.add(highend);
        fishingpoles.add(the);
        System.out.println(fishingpoles.get(sb1).getName());
        if (fishingpoles.get(sb1).getName() == "기본낚시대") {
            System.out.println("-=-=-=-=-=--=-=-=-");
            System.out.println("[기본낚시대 획득!]");
            System.out.println("돈 -20");
            System.out.println(fishingpoles.get(sb1).getCategoryNum());
            기본낚시대 += 1;
            money -= 20;
        } else if (fishingpoles.get(sb1).getName() == "중견낚시대") {
            System.out.println("-=-=-=-=-=--=-=-=-");
            System.out.println("[중견낚시대 획득!]");
            System.out.println("돈 -30");
            중견낚시대 += 1;
            money -= 30;
        } else if (fishingpoles.get(sb1).getName() == "고급낚시대" & 중견낚시대 == 1) {
            System.out.println("-=-=-=-=-=--=-=-=-");
            System.out.println("[고급낚시대 획득!]");
            System.out.println("-=-=-=-=-=--=-=-=-");
            System.out.println("중견낚시대 교환");
            System.out.println("돈 -50");
            고급낚시대 += 1;
            money -= 50;
            중견낚시대 -= 1;
        } else if (fishingpoles.get(sb1).getName() == "TheLegend" & 고급낚시대 == 1 & 중견낚시대 == 1) {
            System.out.println("-=-=-=-=-=--=-=-=-");
            System.out.println("[TheLegend 획득!]");
            System.out.println("-=-=-=-=-=--=-=-=-");
            System.out.println("*******************");
            System.out.println("중견+고급낚시대 교환");
            System.out.println("돈 -1000");
            TheLegend += 1;
            중견낚시대 -= 1;
            고급낚시대 -= 1;
            money -= 1000;
        } else {
            System.out.println("좋은장비는 돈이들지");
        }
    }


    public void selling(int categoryNum) {
        ArrayList<fish> fishs = new ArrayList<fish>();

        fish fis = new fish(10, "고등어", 13);
        fish fis1 = new fish(25, "전어", 14);
        fish fis2 = new fish(0, "병", 104);
        fish fis3 = new fish(0, "소주병", 105);
        fish fis4 = new fish(100, "100원", 106);
        fish fis5 = new fish(0, "쓰레기덩어리", 103);
        fish fis6 = new fish(40, "돌돔", 16);
        fish fis7 = new fish(50, "문어", 17);
        fish fis8 = new fish(0, "바다 쓰레기", 100);
        fish fis9 = new fish(0, "새끼복어", 101);
        fish fis10 = new fish(0, "쓰레기봉지", 102);
        fish fis11 = new fish(30, "갈치", 15);
        fish fis12 = new fish(0, "참이슬 소주병", 105);
        fish fis13 = new fish(0, "맥주병", 105);
        fish fis14 = new fish(100000, "다랑어", 18);
        fish fis15 = new fish(1000000, "상어", 20);


        if (categoryNum == 13 & 고등어 > 0) {
            고등어 -= 1;
            money += 10;
            System.out.println("[10원획득]");
            System.out.println("아직멀었어...");
        } else if (categoryNum == 14 & 전어 > 0) {
            전어 -= 1;
            money += 25;
            System.out.println("[25원획득]");
            System.out.println("아직멀었어...");
        } else if (categoryNum == 15 & 갈치 > 0) {
            갈치 -= 1;
            money += 30;
            System.out.println("[30원획득]");
            System.out.println("아직멀었어...");
        } else if (categoryNum == 16 & 돌돔 > 0) {
            돌돔 -= 1;
            money += 45;
            stress -= 5;
            System.out.println("[45원획득]");
            System.out.println("희망이 보여!");
            System.out.println("[!!스트레스감소 -5!!]");
        } else if (categoryNum == 17 & 문어 > 0) {
            문어 -= 1;
            money += 50;
            stress -= 10;
            System.out.println("[50원획득]");
            System.out.println("희망이 보여!");
            System.out.println("[!!스트레스감소 -10!!]");
        } else if (categoryNum == 18 & 다랑어 > 0) {
            다랑어 -= 1;
            money += 100000;
            stress -= 30;
            System.out.println("[100000원획득]");
            System.out.println("희망이 넘쳐!");
            System.out.println("[!!스트레스감소 -30!!]");
        } else if (categoryNum == 20 & 상어 > 0) {
            상어 -= 1;
            money += 1000000;
            stress += 30;
            System.out.println("[1000000원획득]");
            System.out.println("해낼수있어!");
            System.out.println("[!! 장기간 싸움으로인한 스트레스 +30!!]");
            System.out.println("[고진감래]");
        } else{
            System.out.println("\n");
            System.out.println("[해당 고기 잡아오세요]");
        }
    }


    public void skill() {
        fishingPole pole = new fishingPole(0, " ", 0, 0);
        fisher fi = new fisher(" ", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        System.out.println("===========================================================================================================");
        System.out.println("[현 장비소유]");
        System.out.println("[장비 = " + "[기본낚시대 " + this.기본낚시대 + "개] " + "[중견낚시대 " + this.중견낚시대 + "개 + baitSaving 가능] " +
                "[고급낚시대 " + this.고급낚시대 + "개 + baitSaving 가능] " + "[this is TheLegend " + this.TheLegend + "개 + WeatherSoother 가능] " + "]");
        System.out.println("===========================================================================================================");

    }


    Random rand = new Random();

    @Override
    public void run() {

        for (int p = 4; p > 0; p--) {

            amoutOfbait -= 1;

            System.out.println("[탐색중]");

            System.out.println("탐색중 작동금지!!");

            System.out.println("     ");
            try {
                Thread.sleep(1000);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (amoutOfbait == 0) {
                rand.setSeed(System.nanoTime());

                System.out.println("[탐색종료]");
            }
        }
    }

    public void inventory(int foodNu) {

        System.out.println("[Inventory]");
        System.out.println("===========================================================================================================");
        ArrayList<DowningstressItem> foods = new ArrayList<DowningstressItem>();

        DowningstressItem bred = new DowningstressItem(1, "빵", 5, 5);
        DowningstressItem driedBred = new DowningstressItem(2, "건빵", 2, 2);
        DowningstressItem brew = new DowningstressItem(3, "과일주와 스테이크", 20, 20);
        DowningstressItem orange = new DowningstressItem(4, "과일화채", 15, 15);


        if (foodNu == 1) {
            foods.add(bred);
            for (DowningstressItem item : foods) {
                System.out.println(String.format("+ [번호:%d, 내용:%s, 가격:%d, 스트레스감소%d]", item.categoryNum, item.name, item.price, item.stressdowning));
            }
            System.out.println("===========================================================================================================");
        } else if (foodNu == 2) {
            foods.add(driedBred);
            for (DowningstressItem item : foods) {
                System.out.println(String.format("+ [번호:%d, 내용:%s, 가격:%d, 스트레스감소%d]", item.categoryNum, item.name, item.price, item.stressdowning));
            }
            System.out.println("===========================================================================================================");
        } else if (foodNu == 3) {
            foods.add(brew);
            for (DowningstressItem item : foods) {
                System.out.println(String.format("+ [번호:%d, 내용:%s, 가격:%d, 스트레스감소%d]", item.categoryNum, item.name, item.price, item.stressdowning));
            }
            System.out.println("===========================================================================================================");
        } else if (foodNu == 4) {
            foods.add(orange);
            for (DowningstressItem item : foods) {
                System.out.println(String.format("+ [번호:%d, 내용:%s, 가격:%d, 스트레스감소%d]", item.categoryNum, item.name, item.price, item.stressdowning));
            }
            System.out.println("===========================================================================================================");
        }

    }

    public synchronized void mentalWeeken(int 정신약화) {

        for (int u = 0; u < 17; u++) {

            if (정신약화 == 1 && 정성 >= 300) {
                for (int w = 0; w < 3; w++) {
                    amoutOfbait -= 1;
                    System.out.println("[미끼소모 -1]");
                    System.out.println("[탐색중]");
                    System.out.println("현재미끼: " + amoutOfbait);
                    System.out.println("탐색중 작동금지!!");
                    정성 -= 100;
                    System.out.println("     ");
                }


        }

             else if (정신약화 == 0 || 정성 >= 90) {
                정신약화 = 0;
                System.out.println("                                                        [화창한날씨.]");
                System.out.println("                                                        [good day!] ");

            } else if (정신약화 == 1) {
                정신약화 = 정신약화;
                stress += 1;
                System.out.println("                                                        [강한 비바람이 몰아칩니다.]");
                System.out.println("                                                        [정신약화발동] $%$%$#$$$%$@@##%#$@");
            }
            try {
                Thread.sleep(3000);
                  // 쓰레드가 너무 빨리 진행되서..
            } catch (Exception e) {
                if (u == 16) {
                    System.out.println("[날씨 기우는중]");
                }
            }
        }
    }
}




















