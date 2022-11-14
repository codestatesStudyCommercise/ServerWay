package others;

public class ClassTest {

    interface PrintAble{

        // public 과 abstract 는 생략가능
        // static 메서드와 default 메서드를 제외한 모든 메서드에 public abstract 기본으로 추가
        public abstract String getTitle();
        int getPageNum();

        // static 메서드 : public 은 생략가능
        public static void staticMethod(){
            System.out.println("this is Static Method ");
        };
        // static 메서드 : 내부에서 private static 메서드 사용
        public static void staticMethodUsingPrivateMethod(){
            System.out.println("this is Static Method with Private Method");
            System.out.println(getPrivateStatic());
        };

        // --------------------------------------------------------------------------------------------------

        // default 메서드 : public 은 생략가능
        public default void doNotAnythig(){

        };

        // default 메서드 : 내부에서 private 메서드 사용
        public default void doSomeThing(){
            System.out.println("doSomeThing 1 !!! -> " + getPrivateNotStatic());
        }
        // --------------------------------------------------------------------------------------------------

        // private 메서드
        private String getPrivateNotStatic(){
            return "using Private Method Not Static";
        }
        // private static 메서드
        private static String getPrivateStatic(){
            return "using Private Method Static";
        }
    }

    interface PrintAble2 {

        public abstract String getTitle();
        int getPageNum();

        public default void doSomeThing(){
            System.out.println("doSomeThing 1 !!!");
        }
    }

    // PrintAble 를 구현한 Paper 클래스
    static class Paper implements PrintAble, PrintAble2{

        @Override
        public String getTitle() {
            return "연간보고서";
        }

        @Override
        public int getPageNum() {
            return 600;
        }

        @Override
        public void doNotAnythig() {
            PrintAble.super.doNotAnythig();
            System.out.println("메롱");
        }

        @Override
        public void doSomeThing() {
            PrintAble2.super.doSomeThing();
        }
    }

    // main
    public static void main(String[] args) {

        Paper paper = new Paper();
        PrintAble paper2 = new Paper();

        System.out.println("1) 인터페이스의 메서드를 구현한 메서드 호출");
        System.out.println(paper.getTitle());
        System.out.println(paper.getPageNum());
        System.out.println();

        System.out.println("2) default 메서드 호출");
        paper.doNotAnythig(); // default Method 호출 : 내용 없음
        paper.doSomeThing(); // default Method 호출 : 내부에서 private 메서드 호출
        System.out.println();

        System.out.println("3) static 메서드 호출");
        // paper.staticMethod(); // static 메서드이므로 불가능
        PrintAble.staticMethod(); // static Method 호출
        PrintAble.staticMethodUsingPrivateMethod(); // static Method 호출 : 내부에서 private static 메서드 호출
        System.out.println();

        System.out.println("4) private 메서드 호출");
        // paper.getPrivateNotStatic(); // private 메서드 외부 호출 불가능
    }
}

// 무신사
// 장바구니
// 상품
// 쿠폰
// 결제하기

// 요구정의서
// 객체 설계서
// 코드작성

