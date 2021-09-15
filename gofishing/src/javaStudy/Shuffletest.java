package javaStudy;
import person.Item.fish;

import java.util.Arrays;
import java.util.Random;

public class Shuffletest {

        public static void main(String[] args) {
            // 문자열 배열 생성
            fish[]f=new fish[5];
            f[0]=new fish(10, "고등어", 13);
            f[1]=new fish(25, "전어", 14);
            f[2]=new fish(30, "갈치", 15);
            f[3]=new fish(40, "돌돔", 16);
            f[4]=new fish(50, "문어", 17);

            String b[] = new String[f.length];
            // 복사
            System.arraycopy(f, 0, b, 0, f.length);
            // 섞기
            Random rand = new Random();
            for (int i = b.length - 1; i > 0; i--) {
                int randIdx = rand.nextInt(i + 1);
                String temp = b[randIdx];
                b[randIdx] = b[i];
                b[i] = temp;
            }
            // 출력
            System.out.println(Arrays.toString(f));
            System.out.println(Arrays.toString(b));
        }
    }

