package EnumTest;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;

enum Seasons { SPRING, SUMMER, FALL, WINTER}
enum LANGUAGE { C, JAVA, PYTHON, JAVASCRIPT}
enum Coffees {
    // 끝에 세미콜론 유의
    AMERICANO(10, 150){
        boolean isIncludeMilk(){
            System.out.println("추상메서드 구현 : private static 필드 사용 : " + dailyMaxCaffeine);
            // private 필드는 사용 불가
            // System.out.println("추상메서드 구현 : private final 필드 사용 : " + basicValuePrivate);
            System.out.println("추상메서드 구현 : protected final 필드 사용 : " + basicValueProtected);
            return false;}
    },
    CAPPUCCINO(110, 75){
        boolean isIncludeMilk(){
            System.out.println("추상메서드 구현 : private static 필드 사용 : " + dailyMaxCaffeine);
            // private 필드는 사용 불가
            // System.out.println("추상메서드 구현 : private final 필드 사용 : " + basicValuePrivate);
            System.out.println("추상메서드 구현 : protected final 필드 사용 : " + basicValueProtected);
            return true;}
    },
    CAFFELATTE(180, 75){
        boolean isIncludeMilk(){
            System.out.println("추상메서드 구현 : private static 필드 사용 : " + dailyMaxCaffeine);
            // private 필드는 사용 불가
            // System.out.println("추상메서드 구현 : private final 필드 사용 : " + basicValuePrivate);
            System.out.println("추상메서드 구현 : protected final 필드 사용 : " + basicValueProtected);
            return true;}
    },
    CAFFEMOCHA(290, 95){
        boolean isIncludeMilk(){
            System.out.println("추상메서드 구현 : private static 필드 사용 : " + dailyMaxCaffeine);
            // private 필드는 사용 불가
            // System.out.println("추상메서드 구현 : private final 필드 사용 : " + basicValuePrivate);
            System.out.println("추상메서드 구현 : protected final 필드 사용 : " + basicValueProtected);
            return true;}
    };

    // 상수의 값을 담기위한 변수 선언 : private final
    private static final Coffees[] COFFEES_ARR = Coffees.values();
    private final int kcal;
    private final int caffeine;
    private static final int dailyMaxCaffeine = 400;
    public final int basicValuePrivate = 99999;
    protected final int basicValueProtected = 77777;

    // 생성자 : 열거형은 묵시적 private
    Coffees(int kcal, int caffeine) {
        this.kcal = kcal;
        this.caffeine = caffeine;
    }

    // 인스턴스 메서드 : 하루 권장섭취량 출력
    public void recommendDailyMax(){
        System.out.println("섭취한 커피 : " + this);
        System.out.println("섭취한 카페인 양 : " + this.caffeine + " mg");
        System.out.println("하루 권장 섭취량은 " + dailyMaxCaffeine + "mg 입니다.");
        System.out.println("권장 섭취량으로부터 " + (dailyMaxCaffeine - this.caffeine) + "mg 남았습니다.");
        System.out.println("***참고 " + this + " 칼로리 정보 : " + kcal + " kcal");
    }

    // static 메서드 : 카페인이 가장 낮은 커피 return
    public static Coffees getLowestKcalCoffee(){
        int index = 0;
        int temp = COFFEES_ARR[0].kcal;
        for (int i = 0; i < COFFEES_ARR.length; i++) {
            if (temp > COFFEES_ARR[i].kcal){
                index = i;
                temp = COFFEES_ARR[i].kcal;
            }
        }
        return COFFEES_ARR[index];
    }

    abstract boolean isIncludeMilk();

    // getter
    public int getKcal() {
        return kcal;
    }
    public int getCaffeine() {
        return caffeine;
    }
}

public class Main {
    public static void main(String[] args) {

//        // Test3
//
//        // 생성
//        EnumSet<Coffees> coffees1 = EnumSet.noneOf(Coffees.class);
//        EnumSet<Coffees> coffees2 = EnumSet.allOf(Coffees.class);
//        EnumSet<Coffees> coffees3 = EnumSet.of(Coffees.CAFFELATTE, Coffees.AMERICANO);
//
//        // 복사
//        EnumSet<Coffees> coffees4 = EnumSet.copyOf(coffees3);
//
//        // 조회
//        Iterator<Coffees> iterator = coffees2.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        System.out.println();
//
//        // 특정 값 제외
//        EnumSet<Coffees> complCoffees = EnumSet.complementOf(coffees3);
//        System.out.println(complCoffees);
//        iterator = complCoffees.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        System.out.println();
//
//        // 추가
//        coffees4.add(Coffees.CAPPUCCINO);
//        iterator = coffees4.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        System.out.println();
//
//        // 포함 확인
//        System.out.println("카푸치노 포함여부 : " + coffees4.contains(Coffees.CAPPUCCINO));
//        System.out.println();
//
//        // 삭제
//        coffees4.remove(Coffees.CAPPUCCINO);
//        System.out.println("카푸치노 포함여부 : " + coffees4.contains(Coffees.CAPPUCCINO));
//        System.out.println();


        // Test2
        Coffees latte = Coffees.CAFFELATTE; // 열거형 참조
        latte.recommendDailyMax(); // 인스턴스 메서드 출력 : 권장 섭취량 대비 섭취량 출력
        System.out.println("우유를 포함하고 있나요? : " + latte.isIncludeMilk()); // 추상메서드 구현

        System.out.println();

        Coffees americano = Coffees.getLowestKcalCoffee(); // static 메서드 호출
        americano.recommendDailyMax(); // 인스턴스 메서드 출력 : 권장 섭취량 대비 섭취량 출력
        System.out.println("우유를 포함하고 있나요? : " + americano.isIncludeMilk()); // 추상메서드 구현



//        // Test1
//
//        // 다양한 방식의 Enum 참조
//        Seasons seasons1 = Seasons.SPRING;
//        Seasons seasons2 = Seasons.valueOf("SPRING");
//        Seasons seasons3 = Enum.valueOf(Seasons.class, "SPRING");
//
//        System.out.println("Seasons.SPRING == Seasons.SPRING : " + (seasons1 == seasons2));
//        // System.out.println("Seasons.SPRING > Seasons.SPRING : " + (seasons1 > seasons2)); : 대소비교 불가능
//        System.out.println("Seasons.SPRING.compareTo(Seasons.SPRING) : " + (seasons1.compareTo(seasons2)));
//
//
//        switch (seasons1) {
//            // case 문에 열거형 이름 없이 상수 이름만 적어야하는것에 유의
//            case SPRING:
//                System.out.println("봄");
//                break;
//            case SUMMER:
//                System.out.println("여름");
//                break;
//            case FALL:
//                System.out.println("가을");
//                break;
//            case WINTER:
//                System.out.println("겨울");
//                break;
//        }
    }
}
