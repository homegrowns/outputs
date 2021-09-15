package javaStudy;

public class MyClass {
    // public 리턴형 메서드명 (매개뱐수들) {필요 기능구현}
    public void method1() {
        System.out.println("m1 실행..");
    }

    public void method2(int x) {
        System.out.println(x +"을 이용한 m2 실행");
    }

    public int method3() {
        System.out.println("m3 실행..");
        return 10;
    }

    public void method4(int x, int y) {
        System.out.println(x + y + " m4 실행");
    }

    public int method5(int y) {
        System.out.println("m1 실행..");
        return y*2;
    }

}
