package classtest;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println("animal.name = " + animal.getName());
        System.out.println("animal.eyesNum = " + animal.getEyesNum());
        System.out.println("animal.legsNum = " + animal.getLegsNum());
        System.out.println();

        // 업캐스팅
        Animal dogToAnimal = new Dog();
        System.out.println("dogToAnimal.name = " + dogToAnimal.getName()); // 멍멍이
        System.out.println();

        // 업캐스팅
        Animal HumanToAnimal = new Human();
        System.out.println("HumanToAnimal.class = " + HumanToAnimal.getClass());
        System.out.println("HumanToAnimal.name = " + HumanToAnimal.getName()); // 사람
        // System.out.println("HumanToAnimal.handsNUm = " + HumanToAnimal.getHandsNum()); // 불가능 : 참조변수가 Animal 이기에 Animal 에는 getHansNum 이 없다.
        System.out.println();

        // 다운캐스팅
        // Dog animalToDog = (Dog) new Animal(); // 불가능 : 다운캐스팅 불가능
        // System.out.println("animalToDog = " + animalToDog.getName());

        // 다운캐스팅 예외상황
        Dog firstDog = new Dog();
        System.out.println("firstDog.class = " + firstDog.getClass());
        Animal firstAnimal = (Animal) firstDog;
        System.out.println("firstAnimal.class = " + firstAnimal.getClass());
        System.out.println("firstAnimal.name = " + firstDog.getName()); // 멍멍이
        Dog secondDog = (Dog) firstAnimal; // 가능 : 예외상황 : 이미 업캐스팅 됬던놈을 다운캐스팅 하는 경우는 가능
        System.out.println("secondDog.class = " + secondDog.getClass());
        System.out.println("secondDog.name = " + secondDog.getName()); // 멍멍이
        System.out.println();


    }
}
