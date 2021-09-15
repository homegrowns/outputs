package javaStudy;

public class MyClassExam {

    public static void main(String[] args) {
     MyClass myClass = new MyClass(); //new 키워드를 이용하면 인스턴트를 얼마든지 만들수 있다.


     myClass.method1();
     myClass.method2(20);
     int value = myClass.method3();
     System.out.println("m3가 리턴한값"+ value);
     myClass.method4(5, 10);
     int price = myClass.method5(15);
     System.out.println("m5가 리턴하셧송 "+price);
 }
}
