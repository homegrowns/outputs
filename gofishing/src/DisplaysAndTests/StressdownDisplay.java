package DisplaysAndTests;

import person.Item.*;

import person.Weather.PoisonedWeather;
import person.fisher;

import java.util.ArrayList;

public class StressdownDisplay { // gas Points 포함 bait포함

 public static void stress(fisher fi) {
        System.out.println("stress points: " + fi.getStress() + " / " + fi.getStessMaxMax());
  }
  public static void gas(fisher fi) {
      System.out.println("gas points: "+ fi.get정성Points()+" / ");
  }

  public static void bait(fisher fishingboy) {
      System.out.println("미끼: "+ fishingboy.getAmoutOfbait()+" / "+ fishingboy.getBaitMax());
  }
    public static void 정신(PoisonedWeather pow) {
        System.out.println("정신수치 : "+ pow.get정신약화()+" / "+ "1 : 정신약화 , 2 : 정상");
    }
  /////////////////////////////////////////////////////////// 상태보여주기
  public static void StressAndGas(fisher fi) {
      stress(fi);
      gas(fi);
  }


    public static void 정신약화상태(PoisonedWeather pow) {
     정신(pow);
    }


    public static void baitbait(fisher fishb) {
      bait(fishb);
  }
/////////////////////////////////////////////////////////
     public static void basicDetails(Item item) {
         System.out.println("Item Name: " + item.getName());

     }
    //////////////////////////////////////////////////////// 감소 증가 연산


    public static void details(fishingPole pole) {
          basicDetails(pole);
          System.out.println("stress 감소: " + pole.getDowmstress());
      }  
      public static void details3(DowningstressItem downingstressItem) {
        basicDetails(downingstressItem);
        System.out.println("stress 감소: " + downingstressItem.getDowmstress());
    }


      public static void detalis2(Bait bait) {
       basicDetails(bait);
          System.out.println("미끼증가: "+ bait.GetBait() );
      }


    public static void details(String name) {
    }
}
