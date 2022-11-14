package others;

public class TypeCastTest {

    public static void main(String[] args) {
        int numOne = 49;
        char charOne = (char) numOne;
        // charOne = 1
        System.out.println("charOne = " + charOne);

        int numTwo = 2;
        char charTwo = Character.forDigit(11, 16);
        // charTwo = 2
        System.out.println("charTwo = " + charTwo);

        int numThree = 3;
        char charThree = (char)(numThree +'0');
        // charThree = 3
        System.out.println("charThree = " + charThree);

        int numFour = 4;
        char charFour = Integer.toString(4).charAt(0);
        // charFour = 4
        System.out.println("charFour = " + charFour);
    }
}
