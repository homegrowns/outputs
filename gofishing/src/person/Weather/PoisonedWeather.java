package person.Weather;

import person.fisher;

public class PoisonedWeather extends Thread {

    fisher fishiman;




    public int 정신약화;


    public PoisonedWeather(fisher fishiman, int 정신약화 ) {

        this.fishiman = fishiman;
        this.정신약화 = 정신약화;

    }

    public int get정신약화() {
        return 정신약화;
    }

    @Override
    public void run() {
        fishiman.mentalWeeken(정신약화);




    }

}


