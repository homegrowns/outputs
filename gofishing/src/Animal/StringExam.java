package Animal;

public class StringExam {
    public static void main(String[] args) {
        String str = "HelloDear";

        System.out.println(str.length());
        System.out.println(str.concat(" world"));
        System.out.println(str.substring(3));
        System.out.println(str.substring(3,7)); //begin<= x < end
    }
}
