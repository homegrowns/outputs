package javaStudy;

public class PrintThread2 extends Thread{
    public void run() {
        try {

                for (int i = 10; i > 0; i--) {


                    System.out.println("                                 =소비 " + "[-1 gas]=");
                    System.out.println("                                 =gas 잔여량: " + i + " gas=");
                    if (i < 3) {
                        System.out.println("[연료부족!]");
                        System.out.println("[연료부족!]");
                    }


                Thread.sleep(2000);


                //if(Thread.interrupted()) {
                //if(Thread.currentThread().isInterrupted()) {
                //break;
                //}
            }
        } catch (InterruptedException e) {
            System.out.println("interrupt() 실행");
        }
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}