package javaStudy;

import person.fisher;

import java.util.Scanner;

public class InterruptExample {

    public static void main(String[] args) {
        Thread thread = new PrintThread2();
        thread.start();


        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }
        thread.interrupt();
    }
}

