package person;

import DisplaysAndTests.StressdownDisplay;


import person.Gui.bossFish;
import person.Gui.fishpic;
import person.Item.*;
import person.Weather.PoisonedWeather;
import person.Weather.weatherMethod;

import javax.swing.*;
import java.util.*;


public class main extends JFrame {

    public static void main(String[] args) throws InterruptedException {


//music

        Musics musics = new Musics();

        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("==================================================================");
        System.out.println("              **      ***           **                ");
        System.out.println("     *******        **   *  **                     ***** ");
        System.out.println("     **       **   ***      **      **  *****     **      ");
        System.out.println("     *****    **     ****   *** **  **  *******  **  **** ");
        System.out.println("     **       **   *    **  **   ** **  **   **  **    ** ");
        System.out.println("     **       **    ****    **   ** **  **   **   ****** ");
        System.out.println("==================================================================");
        System.out.println("낚시게임입니다.");
        System.out.println("현상금 붙은 돌연변이물고기를 잡아");
        System.out.println("빛 '1억'을 값으면 승리합니다.");
        System.out.println(" ");
        musics.playsound("src/Audio/한숨소리-짧은-남자 (online-audio-converter.com).wav" ,false);
        System.out.println("[1억이라니...]");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--==");
        System.out.println("[2021년 부터 2040년까지 일본정부의 후쿠시마 방사능오염수 방출계획으로 전세계 바다가 오염되기 시작하고] ");
        System.out.println("[그로인해 돌연변이가 시작된 바다생물들 그와중에 거대 돌연변히화 되어 생태계 교란종이된 돌연변이돌돔을 정부차원에서 현상금을 걸게 되는데...] ");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--==");
        System.out.println("이름을 입력하시오.");
        System.out.print(" => ");
        String name = sc.next(); // 이름을 입력받음
                                               //100000000

        fisher fishman = new fisher(name, 99999999,0, 100, 10, 10, 50,
                0, 0, 0,0 , 0, 1, 1,0, 0,0,1);

         // npc
        MarketMan mman = new MarketMan("상점주인");



////////////////////////////////////////
        // Items

        ArrayList<prayer> arrayList = new ArrayList<prayer>();

        prayer charm = new prayer( "정성부적", 11, 100,30);
        prayer pray = new prayer("제사지내기" , 12, 10, 10);




        ArrayList<DowningstressItem> foods = new ArrayList<DowningstressItem>();

        DowningstressItem 빵= new DowningstressItem(0, "빵", 5, 5);
        DowningstressItem 건빵 = new DowningstressItem(1, "건빵", 2, 2);
        DowningstressItem 과일주와스테이크 = new DowningstressItem(2, "과일주와스테이크", 20, 20);
        DowningstressItem 과일화채 = new DowningstressItem(3, "과일화채", 15, 15);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        DowningstressItem food = new DowningstressItem(0, " ", 0, 0);
        Bait bait = new Bait(0, " ", 0, 0);
        prayer pr = new prayer(" ", 0, 0, 0);
        fishingPole fishingpoless = new fishingPole(0, " ", 0, 0);

        MutantFish mfish = new MutantFish(0," ",0,0);


        ArrayList<fishingPole> fishingpoles = new ArrayList<fishingPole>();

        fishingPole basic = new fishingPole(0,"기본낚시대",10, 5);
        fishingPole veteran = new fishingPole(1, "중견낚시대",20,10);
        fishingPole  highend = new fishingPole(2, "고급낚시대", 50,30);
        fishingPole  the = new fishingPole(3, "TheLegend", 1000,100);

        fishingpoles.add(basic);
        fishingpoles.add(veteran);
        fishingpoles.add(highend);
        fishingpoles.add(the);

        ArrayList<fish> fishs = new ArrayList<fish>();

        fish fishss = new fish(0," ",0);

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

        ArrayList<MutantFish> mfishs = new ArrayList<MutantFish>();

        MutantFish mfis = new MutantFish(1000000, "TheMutant돌돔", 1000,666);
        MutantFish mfis1 = new MutantFish(0, "입두개 달린 전어", 14,0);
        MutantFish mfis2 = new MutantFish(0, "병든 물고기", 104,0);
        MutantFish mfis3 = new MutantFish(0, "소주병", 105,0);
        mfishs.add(mfis);
        mfishs.add(mfis1);
        mfishs.add(mfis2);
        mfishs.add(mfis3);



////////////////////////////////////////////////////////
        Random rand =  new Random();
        weatherMethod wm = new weatherMethod();

        for (int i = 0; i < 100; i++) {

            int num = rand.nextInt(1+1);

            PoisonedWeather pw = new PoisonedWeather(fishman, num);

            pw.start();
            if (fishman.stress < fishman.stressMax) {
                 if (fishman.money >= 100000000) {

                    System.out.println(".............");
                     System.out.println(" ");
                     System.out.println("==============================================");
                    System.out.println("드디어 해내다니!");
                    System.out.println("당신은 빛을 청산합니다.");
                    musics.playsound("src/Audio/test.wav", false);
                    System.out.println("[ 엔딩 ]");
                    System.out.println("[ 인간승리 ]");
                     System.out.println("==============================================");
                     System.out.println("종료합니다.");

                     System.exit(0);
                }

                System.out.println("==============================================================");
                System.out.print("[1. 상태창 2. 상점방문 3. 출항(돈30이상출발) 4. 휴식(!!-40) 5. 종료]");  // \ n 은 한칸 내리기 기능
                System.out.println("\n==============================================================");
                int x = sc.nextInt(); //

                if (x == 1) {
                    fishman.lookatStatus(); //상태획인
                } else if (x == 2) {
                    mman.talk();
                    System.out.println("============================================");
                    System.out.println("[1.식당 2.미끼 3.부적and제사 4.낚시도구밎관련물품]");
                    System.out.println("============================================");
                    int u = sc.nextInt();
                    if (u == 1) {
                        food.market();
                        System.out.println("==========================================");
                        System.out.println("[ 1. 드시고 가시나요? 2. 밥좀싸주세요 ]");
                        int u2 = sc.nextInt();
                        if (u2 == 1) {
                            System.out.println("for here");
                            System.out.println(" ");
                            System.out.print("구매번호:");
                            int u1 = sc.nextInt();
                            if (u1 == 1 & fishman.money > 0) {
                                fishman.downStress(5);
                                System.out.println("버억~");
                                System.out.println("[스트레스 5감소]");
                            } else if (u1 == 2 & fishman.money > 0) {
                                fishman.downStress(2);
                                System.out.println("버억~");
                                System.out.println("[스트레스 2감소]");
                            } else if (u1 == 3 & fishman.money > 0) {
                                fishman.downStress(20);
                                System.out.println("버억~");
                                System.out.println("[스트레스 20감소]");
                            } else if (u1 == 4 & fishman.money > 0) {
                                fishman.downStress(15);
                                System.out.println("버억~");
                                System.out.println("[스트레스 15감소]");
                            } else {
                                System.out.println("돈없으면 가라"); // 안됨
                            }
                        }else if (u2 ==2 ) {
                            System.out.println("TakeOut");
                            System.out.println(" ");
                            System.out.println("[거래후 인벤토리저장]");
                            System.out.println("==========================================");
                            System.out.println("( 메뉴 )");
                            food.market();
                            System.out.println("==========================================");
                            System.out.println("[번호입력]");
                            int z = sc.nextInt();
                            if (z == 1) {
                                foods.add(빵);
                                for (DowningstressItem item : foods) {
                                    System.out.println(String.format("+ [번호:%d, 내용:%s, 가격:%d, 스트레스감소%d]", item.categoryNum, item.name, item.price, item.stressdowning)); }
                                System.out.println("===========================================================================================================");
                            } else if (z == 2) {
                                foods.add(건빵);
                                for (DowningstressItem item : foods) {
                                    System.out.println(String.format("+ [번호:%d, 내용:%s, 가격:%d, 스트레스감소%d]", item.categoryNum, item.name, item.price, item.stressdowning)); }
                                System.out.println("===========================================================================================================");
                            } else if (z == 3) {
                                foods.add(과일주와스테이크);
                                for (DowningstressItem item : foods) {
                                    System.out.println(String.format("+ [번호:%d, 내용:%s, 가격:%d, 스트레스감소%d]", item.categoryNum, item.name, item.price, item.stressdowning)); }
                                System.out.println("===========================================================================================================");
                            } else if (z == 4) {
                                foods.add(과일화채);
                                for (DowningstressItem item : foods) {
                                    System.out.println(String.format("+ [번호:%d, 내용:%s, 가격:%d, 스트레스감소%d]", item.categoryNum, item.name, item.price, item.stressdowning)); }
                                System.out.println("===========================================================================================================");
                            }
                        }
                        } else if (u == 2 && fishman.money>0) {
                        bait.market();
                        System.out.println("==========================================");
                        System.out.print("구매번호:");
                        int u1 = sc.nextInt();
                        if (u1 == 5 & fishman.money > 0) {
                            fishman.plusBait(2);
                            System.out.println("[미끼2획득]");
                        } else if (u1 == 6 & fishman.money > 0) {
                            fishman.plusBait(1);
                            System.out.println("[미끼1획득]");
                        } else if (u1 == 7 & fishman.money > 0) {
                            fishman.plusBait(20);
                            System.out.println("[미끼20획득]");
                        } else {
                            System.out.println("훠이~ 돈없으면가");
                        }


                    } else if (u == 3 && fishman.money>0) {
                       pr.market();
                        System.out.println("==========================================");
                        System.out.println("[번호입력]");
                        int z = sc.nextInt();
                        if (z == 11) {
                            fishman.정성 +=50;
                            arrayList.add(charm);
                            for (prayer item : arrayList) {
                                System.out.println(String.format("+ [번호:%d, 내용:%s, 가격:%d, 정성도%d]", item.categoryNum, item.name, item.price, item.정성Points)); }
                            System.out.println("===========================================================================================================");
                        } else if (z == 12) {
                            fishman.정성 +=10;
                            System.out.println("[기우제를 지내다]");
                            for (prayer item : arrayList) {
                                System.out.println(String.format("+ [번호:%d, 내용:%s, 가격:%d, 정성도%d]", item.categoryNum, item.name, item.price, item.정성Points)); }
                            System.out.println("===========================================================================================================");
                        }

                    } else if (u == 4) {
                        System.out.println("==========================================");
                        System.out.println("[ 1.물건팔기 2.장비사기 ]");
                        System.out.println(" ");
                        System.out.println("[ 3. 현상금 안내소 ]");
                        System.out.println("==========================================");
                        int sb = sc.nextInt();
                        if (sb == 1 /*& fishman.전어 > 0 & fishman.고등어 > 0 & fishman.돌돔 > 0 & fishman.문어 > 0 & fishman.갈치 > 0 & fishman.다랑어 > 0 & fishman.상어 > 0*/) {
                            fishss.kindsFish();
                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                            System.out.println("[카테고리 넘버를 입력하세요]");
                            System.out.print("=");
                            int sb1 = sc.nextInt();
                            musics.playsound("src/Audio/006.자막효과음_돈딴거.wav", false);
                            fishman.selling(sb1);


                        } else if (sb == 2 & fishman.money > 0) {

                            System.out.println("[낚시대가 좋을수록 힘이덜들어 스트레스를 적게밭는다]");
                            System.out.println("[고급=중급낚시대 재료 + 돈, 최상위= 고급,중급 재료 + 돈]");
                            System.out.println("==========================================");
                            fishingpoless.marketforpole();
                            System.out.println("==========================================");
                            System.out.println("번호 입력");
                            int sb1 = sc.nextInt();
                            fishman.buying(sb1);
                        } else if (sb==3){
                            System.out.println("[............]");
                            System.out.println("[돌연변이는 잡았나?]");
                            System.out.println("[현상금을 받고싶으면 물건을 그 legend번호를대고 물건을 보여줘라]");
                            System.out.print("=");
                            int mn = sc.nextInt();
                             if (mn==666){
                                 System.out.println("[드디어!!]");
                                 int sb2 = sc.nextInt();
                               mman.buying();
                                 fishman.money += 100000000;
                                     musics.playsound("src/Audio/006.자막효과음_돈딴거.wav", false);

                             }
                    } else {
                            System.out.println("??=-=");
                            System.out.println("이런이런.. 잡은게없내..고기잡으러 가자");
                        }
                    }
                }

                else if (x == 3 && fishman.money>=30 ) {


                        fishman.depart();
                        System.out.println(" ");
                        System.out.println("날씨에 따라 고기를 잡을수있는 확률이 달라집니다..");
                        System.out.println("출발전 하늘에 정성을 다하세요.");
                    System.out.println("  ");
                    System.out.println("==============================================");
                        System.out.println("현재 정성 수치: " + fishman.정성);
                    System.out.println("==============================================");
                    System.out.println("  ");
                    System.out.println("  ");

                        for (int j = 1; j <= fishman.stressMax; j++) {
                            fishman.stress += 1;
                            System.out.println("[행동 동안 스트레스를 계속얻습니다.]");
                            System.out.println("[상태를 항상확인하세요.]");
                            System.out.println("==============================================");
                            System.out.print("[1. 상태창 2.낚시 3.회항 4. 인벤토리확인 ]");  // \ n 은 한칸 내리기 기능
                            System.out.println("\n==============================================");
                            int y = sc.nextInt();
                            if (fishman.stress >= fishman.stressMax) {
                                System.out.println(".................상태창을 자주확인하세요");
                                fishman.die();
                                break;
                            } else if (y == 1) {
                                fishman.lookatStatus();
                                fishman.skill();
                                System.out.println(" ");
                                System.out.println("======================================================================================================");
                                System.out.println("                              [스킬사용]");
                                System.out.println("[1.WeatherSoother(TheLegend전용) 2. baitSaving(중견: 전어 사용) 3. baitSaving(고급낚대: 고등어 사용) 0. 뒤로");
                                System.out.println("======================================================================================================");
                                int sk = sc.nextInt();
                                System.out.print("= ");
                                if (sk==1 && fishman.TheLegend==1 && fishman.다랑어== 1) {
                                    fishingpoless.WeatherSoother();
                                    fishman.정성 += 90;
                                    fishman.다랑어 -=1;

                                    pw.interrupt();
                                    System.out.println("[스킬사용 정성증가..]");



                                }else if (sk==2 && fishman.중견낚시대==1&& fishman.전어>=1 ) {
                                    fishingpoless.stayingBait();
                                    fishman.amoutOfbait +=1;
                                    fishman.전어 -=1;
                                    System.out.println("[전어 -1] [미끼2 획득]");
                                }else if ( sk==3 && fishman.고급낚시대==1 && fishman.고등어>=1) {
                                    fishingpoless.stayingBait();
                                    fishman.고등어 -=1;
                                    fishman.amoutOfbait +=1;
                                    System.out.println("[고등어 -1] [미끼2 획득]");
                                }else if (sk==0) {
                                    System.out.println("뒤로");
                                } else {
                                    System.out.println("[제물 다랑어필요 1번스킬발동]");
                                    System.out.println("[2. 중견낚시대 전어필요]");
                                    System.out.println("[3. 고급낚시대 고등어필요]");
                                }

                            } else if (y == 2 & fishman.amoutOfbait > 0) {
                                System.out.println("[장비선택]");
                                System.out.println("--=================================================--");
                                fishman.showingFpole();
                                int qc = sc.nextInt();
                                System.out.print("번호= " + qc);
                                if (qc == 0 & fishman.기본낚시대 == 1) {
                                    System.out.println(" [" + fishingpoles.get(qc).getName() + " 장착 ] ");
                                    System.out.println(" ");
                                    System.out.println("1+4");
                                    System.out.print("=  ");
                                    int qui = sc.nextInt();
                                    fishman.equip(qui);                                                                 //기본낚시대 지렁이:3~8 good:3 , bad:3  떡밥:0~2 good:2 bad:1
                                    System.out.println("==========================================");
                                    System.out.println("미끼선택");
                                    System.out.println("==========================================");
                                    System.out.println("[1.지렁이 2.떡밥]");   /// 잡을수있는고기가 미끼에따라다르다
                                    System.out.println("==========================================");
                                    int q = sc.nextInt();
                                    if (q == 1 && fishman.amoutOfbait >= 2) {
                                        fishman.fishing(2);
                                        rand.setSeed(System.nanoTime());

                                        int min = 3, max = 8;
                                        Set<Integer>result = new TreeSet<>();
                                        while (result.size() != 1) {
                                            result.add(rand.nextInt(max - min + 1) + min);
                                        }for (int number : result) {
                                        if (pw.정신약화 == 1) {
                                            rand =  new Random();
                                            int fishNum = rand.nextInt(3+1);

                                            number = fishNum;

                                            System.out.println(" ");
                                            System.out.println(" ");
                                            System.out.println("==========================================");
                                            System.out.println(" ");//로딩 쓰레드
                                            System.out.println("걸렸다!! ");
                                            System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                            fishman.itemGet(number);
                                        } else {

                                                System.out.println(" ");
                                                System.out.println(" ");
                                                System.out.println("==========================================");
                                                System.out.println(" ");//로딩 쓰레드
                                                System.out.println("걸렸다!! ");
                                                System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                                fishman.itemGet(number);
                                            }
                                        }
                                    } else if (q == 2) {

                                        fishman.fishing(1);
                                        rand.setSeed(System.nanoTime());

                                        int min = 0, max = 2;
                                        Set<Integer> result = new TreeSet<>();
                                        while (result.size() != 1) {
                                            result.add(rand.nextInt(max - min + 1) + min);
                                        }
                                        for (int number : result) {
                                            if (pw.정신약화 == 1) {
                                                number = 3;

                                                System.out.println(" ");
                                                System.out.println(" ");
                                                System.out.println("==========================================");
                                                System.out.println(" ");//로딩 쓰레드
                                                System.out.println("걸렸다!! ");
                                                System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                                fishman.itemGet(number);
                                            } else {
                                                System.out.println(" ");
                                                System.out.println(" ");
                                                System.out.println("==========================================");
                                                System.out.println(" ");//로딩 쓰레드
                                                System.out.println("걸렸다!! ");
                                                System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                                fishman.itemGet(number);
                                            }
                                        }
                                    } else {
                                        System.out.println("미끼부족");
                                    }
                                } else if (qc == 1 & fishman.중견낚시대 == 1) {
                                    System.out.println(" [" + fishingpoles.get(qc).getName() + " 장착 ] ");
                                    System.out.println(" ");
                                    System.out.println("18-8");
                                    System.out.print("=  ");
                                    int qui = sc.nextInt();
                                    fishman.equip(qui);                                                  // 중견낚시대 지렁이:0~7 good:4 , bad:3  떡밥:0~1 good:2
                                    System.out.println("==========================================");
                                    System.out.println("미끼선택");
                                    System.out.println("==========================================");
                                    System.out.println("[1.지렁이 2.떡밥]");   /// 잡을수있는고기가 미끼에따라다르다
                                    System.out.println("==========================================");
                                    int q = sc.nextInt();
                                    if (q == 1 && fishman.amoutOfbait >= 2) {
                                        fishman.fishing(2);
                                        rand.setSeed(System.nanoTime());

                                        int min = 0, max = 7;
                                        Set<Integer> result = new TreeSet<>();
                                        while (result.size() != 1) {
                                            result.add(rand.nextInt(max - min + 1) + min);}
                                            for (int number : result) {
                                                if (pw.정신약화 == 1) {
                                                    number = 1;

                                                    System.out.println(" ");
                                                    System.out.println(" ");
                                                    System.out.println("==========================================");
                                                    System.out.println(" ");//로딩 쓰레드
                                                    System.out.println("걸렸다!! ");
                                                    System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                                    fishman.itemGet(number);
                                                } else {
                                                    System.out.println(" ");
                                                    System.out.println(" ");
                                                    System.out.println("==========================================");
                                                    System.out.println(" ");//로딩 쓰레드
                                                    System.out.println("걸렸다!! ");
                                                    System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                                    fishman.itemGet(number);
                                                }
                                            }

                                    } else if (q == 2) {

                                        fishman.fishing(1);
                                        rand.setSeed(System.nanoTime());

                                        int min = 0, max = 1;
                                        Set<Integer> result = new TreeSet<>();
                                        while (result.size() != 1) {
                                            result.add(rand.nextInt(max - min + 1) + min);
                                        }
                                        for (int number : result) {
                                        {
                                                System.out.println(" ");
                                                System.out.println(" ");
                                                System.out.println("==========================================");
                                                System.out.println(" ");//로딩 쓰레드
                                                System.out.println("걸렸다!! ");
                                                System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                                fishman.itemGet(number);}
                                        }
                                    }else {
                                        System.out.println("미끼부족");
                                    }
                                } else if (qc == 2 & fishman.고급낚시대 == 1) {
                                    System.out.println(" [" + fishingpoles.get(qc).getName() + " 장착 ] ");
                                    System.out.println(" ");
                                    System.out.println("25+5");
                                    System.out.print("=  ");
                                    int stressdowning = sc.nextInt();
                                    fishman.equip(stressdowning);                                              // 고급낚시대 지렁이:6~15 good:6 , bad:4  떡밥:(0~1,2)~4 good:3 bad:1
                                    System.out.println("==========================================");
                                    System.out.println("미끼선택");
                                    System.out.println("==========================================");
                                    System.out.println("[1.지렁이 2.떡밥]");   /// 잡을수있는고기가 미끼에따라다르다
                                    System.out.println("==========================================");
                                    int q = sc.nextInt();
                                    if (q == 1 && fishman.amoutOfbait >= 2) {
                                        fishman.fishing(2);
                                        rand.setSeed(System.nanoTime());

                                        int min = 6, max = 15;
                                        Set<Integer> result = new TreeSet<>();
                                        while (result.size() != 1) {
                                            result.add(rand.nextInt(max - min + 1) + min);
                                        }
                                        for (int number : result) {
                                            if (pw.정신약화==1) {
                                                number = 6;

                                                System.out.println(" ");
                                                System.out.println(" ");
                                                System.out.println("==========================================");
                                                System.out.println(" ");//로딩 쓰레드
                                                System.out.println("걸렸다!! ");
                                                System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                                fishman.itemGet(number);
                                            }else {
                                            System.out.println(" ");
                                            System.out.println(" ");
                                            System.out.println("==========================================");
                                            System.out.println(" ");//로딩 쓰레드
                                            System.out.println("걸렸다!! ");
                                            System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                            fishman.itemGet(number);}
                                        }
                                    } if (q == 2) {

                                        fishman.fishing(1);
                                        rand.setSeed(System.nanoTime());
                                        // 번호3번 쓰레기 빼기

                                        int min = 0, max = 4;
                                        Set<Integer> result = new TreeSet<>();
                                        while (result.size() != 1) {
                                            result.add(rand.nextInt(max - min + 1) + min);
                                        }
                                        for (int number : result) {
                                            if (pw.정신약화 == 1) {
                                                number = 9;

                                                System.out.println(" ");
                                                System.out.println(" ");
                                                System.out.println("==========================================");
                                                System.out.println(" ");//로딩 쓰레드
                                                System.out.println("걸렸다!! ");
                                                System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                                fishman.itemGet(number);
                                            } else if (number == 3) {
                                                number = 9;
                                                System.out.println(" ");
                                                System.out.println(" ");
                                                System.out.println("==========================================");
                                                System.out.println(" ");//로딩 쓰레드
                                                System.out.println("걸렸다!! ");
                                                System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                                fishman.itemGet(number);
                                            }
                                        }
                                    }
                                }  if (qc == 3 & fishman.TheLegend == 1) {
                                    System.out.println(" [" + fishingpoles.get(qc).getName() + " 장착 ] ");
                                    System.out.println(" ");
                                        System.out.println("10*10");
                                        System.out.print("=  ");
                                        int stressdowning1 = sc.nextInt();
                                        fishman.equip(stressdowning1);                                                         //레전드 차레
                                        System.out.println("[ 오늘 '그'돌돔을 잡을수있을까? ]");
                                        System.out.println("==========================================");
                                        System.out.println("미끼선택");
                                        System.out.println("==========================================");
                                        System.out.println("[1.지렁이 2.떡밥 3.탐색시도]");
                                        System.out.println("==========================================");
                                        int q = sc.nextInt();
                                        if (q == 1 && fishman.amoutOfbait >= 2) {
                                            fishman.fishing(2);
                                            rand.setSeed(System.nanoTime());

                                            int min = 6, max = 15;
                                            Set<Integer> result = new TreeSet<>();
                                            while (result.size() != 1) {
                                                result.add(rand.nextInt(max - min + 1) + min);
                                            }
                                            for (int number : result) {
                                                if (number == 8 || number == 9 || number == 10) {
                                                    number = 1;
                                                    System.out.println(" ");
                                                    System.out.println(" ");
                                                    System.out.println("==========================================");
                                                    System.out.println(" ");//로딩 쓰레드
                                                    System.out.println("걸렸다!! ");
                                                    System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                                    fishman.itemGet(number);
                                                } else {
                                                    System.out.println(" ");
                                                    System.out.println(" ");
                                                    System.out.println("==========================================");
                                                    System.out.println(" ");//로딩 쓰레드
                                                    System.out.println("걸렸다!! ");
                                                    System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                                    fishman.itemGet(number);
                                                }
                                            }

                                        }
                                        if (q == 2) {

                                            fishman.fishing(1);
                                            rand.setSeed(System.nanoTime());

                                            int min = 0, max = 4;
                                            Set<Integer> result = new TreeSet<>();
                                            while (result.size() != 1) {
                                                result.add(rand.nextInt(max - min + 1) + min);
                                            }
                                            for (int number : result) {
                                                if (number == 3 || number == 2) {
                                                    number = 1;
                                                    System.out.println(" ");
                                                    System.out.println(" ");
                                                    System.out.println("==========================================");
                                                    System.out.println(" ");//로딩 쓰레드
                                                    System.out.println("걸렸다!! ");
                                                    System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                                    fishman.itemGet(number);

                                                } else {
                                                    System.out.println(" ");
                                                    System.out.println(" ");
                                                    System.out.println("==========================================");
                                                    System.out.println(" ");//로딩 쓰레드
                                                    System.out.println("걸렸다!! ");
                                                    System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                                    fishman.itemGet(number);
                                                }
                                            }
                                        } else if (pw.정신약화 == 1 && q == 3) {


                                        if (fishman.정성 >= 90) {
                                            System.out.println("[정성 90이상]");
                                            fishman.fishing(1);
                                            rand.setSeed(System.nanoTime());
                                            System.out.println("낚시중");
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
                                                System.out.println(" [" + mfishs.get(number).getName() + "]\t[가격: " + mfishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + mfishs.get(number).getCategoryNum() + "]\t[" + "전설번호" +
                                                        mfishs.get(number).getLegend() + "]");

                                                if (0 == number) {
                                                    mfis.mutantfishLooking();
                                                    mfishs.add(mfis);
                                                    System.out.println("[돌연변이 돌돔을잡았습니다!]");
                                                    System.out.println("[빛을 갚을수 있겠네요!]");
                                                    System.out.println(" ");
                                                    System.out.println(" ");
                                                    System.out.println(" ");

                                                } else {
                                                    System.out.println("[윽., ]");
                                                }
                                            }

                                        } else if (pw.정신약화 == 1) {

                                            System.out.println("분위기가 평소랑 같은걸??");
                                            musics.playsound("src/Audio/공포가 다가 오는 (online-audio-converter.com).wav", false);
                                            System.out.println("탐색중 작동금지!!");

                                            fishman.정성 += 300;



                                                Scanner ic = new Scanner(System.in);
                                            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                                                System.out.println("현 대한민국의 대통령은?");
                                                System.out.println("= ");
                                                String answer = ic.next();

                                                if (answer.equals("문재인")) {
                                                    rand.setSeed(System.nanoTime());
                                                    System.out.println("[탐색]");
                                                    int min = 9, max = 15;
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

                                                        System.out.println(" [" + fishs.get(number).getName() + "]\t[가격: " + fishs.get(number).getPrice() + "]\t[" + "카테고리넘버 :" + fishs.get(number).getCategoryNum() + "]");
                                                        fishman.itemGet(number);

                                                    }
                                                }


                                        }

                                    }else if (q == 3){
                                        System.out.println(" ");
                                        System.out.println("=-=-=-=-=-........");
                                            System.out.println("[정성 90이상 거대돌돔 에게 접근가능]");
                                        System.out.println("[이날씨에는 돌연변이물고기를 잡을수없다.]");
                                    }else {
                                            System.out.println("미끼부족");
                                        }
                                } else if (qc < 0 || qc > 3 ) {
                                    System.out.println("\n");
                                    System.out.println("\n 재선택");
                                }


                            } else if (y == 3) {
                                if (fishman.stress > 90) {
                                    System.out.println(" ");
                                    System.out.println("[아후!.. 언제 빛을 다갚지?]");
                                    System.out.println("[스트레스를 너무 받고있다.]");
                                    fishman.stress += 5;
                                    System.out.println("[스트레스상승 +5]");
                                    fishman.arriveinHurry();
                                    System.out.println("[운전 종료중...]");
                                    System.out.println(" ");
                                    break;
                                } else {
                                    System.out.println("[운전 종료중...]");
                                    System.out.println(" ");
                                    System.out.println("벌써 돌아가나요?");
                                    System.out.println(" ");
                                    System.out.println("[정성이 부족합니다.]");
                                    fishman.정성 -=20;
                                    System.out.println("[-20 정성] ");
                                    fishman.arrive();
                                    break;


                                }

                            } else if (y == 4 || foods.size() > 0) {
                                System.out.println("=======================");
                                System.out.println("[1. 인벤창 확인 2.뒤로]");
                                System.out.println("=======================");
                                System.out.print("= ");
                                int in = sc.nextInt();
                                if (in == 1) {
                                    if (in == 1) {
                                        System.out.println("===========================================================================================================================");
                                        for (int fo = 0; fo < foods.size(); fo++) {
                                            DowningstressItem fal = foods.get(fo);
                                            System.out.println(String.format(fo + ". : " + "[ 내용:%s, 가격:%d, 스트레스감소%d]", fal.name, fal.price, fal.stressdowning));
                                        }
                                        for (int ga = 0; ga < arrayList.size(); ga++) {
                                            prayer g = arrayList.get(ga);
                                            System.out.println(String.format(" 소지중 : " + "[번호:%d, 내용:%s, 가격:%d, 정성도%d] ", g.categoryNum, g.name, g.price, g.정성Points));
                                        }
                                        System.out.println("===========================================================================================================================");
                                        System.out.println("[1. 아이템사용 2. 부적사용 3. 뒤로]");
                                        System.out.print("= ");
                                    }

                                    int inn = sc.nextInt();

                                    if (inn == 1) {
                                        System.out.println("[사용할 아이템 번호 입력]");
                                        System.out.print("= ");
                                        int ds = sc.nextInt();
                                        System.out.println(" ");
                                        if (ds == 0) {
                                            System.out.println("========================");

                                            DowningstressItem foody = foods.get(0);
                                            StressdownDisplay.StressAndGas(fishman);
                                            System.out.println(" ");
                                            // 감소 상태
                                            System.out.println(String.format("소모 : " + "[번호:%d, 내용:%s, 스트레스감소%d]", foody.categoryNum, foody.name, foody.stressdowning));
                                            foody.using(fishman);
                                            foods.remove(foody);
                                            System.out.println("========================");
                                            StressdownDisplay.StressAndGas(fishman);
                                        } else if (ds == 1) {
                                            System.out.println("========================");

                                            DowningstressItem foody = foods.get(1);
                                            StressdownDisplay.StressAndGas(fishman);
                                            System.out.println(" ");
                                            // 감소 상태
                                            System.out.println(String.format("소모 : " + "[번호:%d, 내용:%s, 스트레스감소%d]", foody.categoryNum, foody.name, foody.stressdowning));
                                            foody.using(fishman);
                                            foods.remove(foody);
                                            System.out.println("========================");
                                            StressdownDisplay.StressAndGas(fishman);
                                        } else if (ds == 2) {
                                            System.out.println("========================");

                                            DowningstressItem foody = foods.get(2);
                                            StressdownDisplay.StressAndGas(fishman);
                                            System.out.println(" ");
                                            System.out.println(String.format("소모 : " + "[번호:%d, 내용:%s, 스트레스감소%d]", foody.categoryNum, foody.name, foody.stressdowning));// 감소 상태
                                            foody.using(fishman);
                                            foods.remove(foody);
                                            System.out.println("========================");
                                            StressdownDisplay.StressAndGas(fishman);
                                        } else if (ds == 3) {
                                            System.out.println("========================");

                                            DowningstressItem foody = foods.get(3);
                                            StressdownDisplay.StressAndGas(fishman);
                                            System.out.println(" ");
                                            System.out.println(String.format("소모 : " + "[번호:%d, 내용:%s, 스트레스감소%d]", foody.categoryNum, foody.name, foody.stressdowning));// 감소 상태
                                            foody.using(fishman);
                                            foods.remove(foody);
                                            System.out.println("========================");
                                            StressdownDisplay.StressAndGas(fishman);
                                        }  else {
                                            System.out.println("뒤로");
                                        }
                                    } else if (inn == 2) {
                                        arrayList.remove(charm);
                                        fishman.정성 +=50;
                                        System.out.println("[+50 부적 사용]");

                                    }else if (inn == 3) {
                                        System.out.println("[재선택]");

                                    }


                                }
                            } else {
                                System.out.println("준비가 덜됬나?");
                                System.out.println("아직 연료가 더 남았어");
                                System.out.println("??");
                            }


                        }
                        if (fishman.stress >= fishman.getStessMaxMax()) {
                            System.out.println("[사망]");
                            System.out.println("고 스트레스로 인한 혈압상승!");
                            fishman.die();
                            fishman.stress += 1000;
                            break;
                        }

//////////////////////////////

                }else if (x == 4 & fishman.money > 0) {
                    if (fishman.money >= 50) {
                        System.out.println("편히쉬십쇼!");
                        System.out.println(" ");
                        fishman.sleep(); //휴식
                    } else {
                        System.out.println("돈내십쇼");
                    }
///////////////////////////
                } else if(x == 5) {

                    System.out.println("종료합니다.");

                    System.exit(0);

                }
                else {
                    System.out.println("[재선택]");
                }
       ////////////////////////////////////  (x==num) 마지막 선택지 끝
            } else if (fishman.stress > fishman.stressMax) {              // 돈 갚기기능추가 하자
                System.out.println("높은 스트레스로 사망");
                System.out.println("[스트레스수치를 최대에 달하지않도록 유의해 주세요]");
                fishman.die();
                break;
            } else if (fishman.money >= 100000000) {
                System.out.println(".............");
                System.out.println("드디어 해내다니!");
                System.out.println("당신은 빛을 청산합니다.");
                System.out.println("[ 엔딩 ]");
                System.out.println("[ 인간승리 ]");

            }
        }
    }
}








