package dispatchtest;

import java.util.Arrays;
import java.util.List;

public class SNSSecond {

    // 문제점 1을 개선하여 나온 2번째 코드 : 메서드 오버로딩과 SNS 를 구체화 하여 매개변수로 받아 처리
    /*
        문제점 2. 적용 불가능
            55번째 줄 컴파일 시점에 SNS타입을 찾을수 없다는 내용의 에러 발생
            원인 : 메서드 오버로딩 시 매개변수가 구체적인 타입이기 때문
            메서드 오버로딩은 스테틱 디스패치가 이루어지기 때문에 컴파일 시점에 매개변수의 타입을 정확하게
            지정해두어야한다.
            매서드 오버로딩일 일어나기 위해선 스태틱 디스패치를 해야하는데 주어진 정보만 가지고는
            어느메서드를 실행해야하는지 잡을 수 없다.
            다이나믹 디스패칭 시 다이나믹 조건이 파라미터에 걸려있기때문에 실행되지 않음 : 파라미터는 다이나믹 디스패치의 조건이 되지않는다.
            -> 이를 해결하기 위해선 다형성을 두번 적용하는 과정이 필요함
     */

    // Post
    interface Post {
        // 2. 메서드 오버로딩과 매개변수 타입 구체화 추가
        void postOn(Facebook sns);
        void postOn(Twitter sns);
    }
    static class Text implements Post {
        // 문제 지점
        // 2. 메서드 오버로딩과 매개변수 타입 구체화 추가
        public void postOn(Facebook sns) {
            System.out.println("text-facebook");
        }
        public void postOn(Twitter sns) {
            System.out.println("text-twitter");
        }
    }
    static class Picture implements Post {
        // 2. 메서드 오버로딩과 매개변수 타입 구체화 추가
        public void postOn(Facebook sns) {
            System.out.println("picture-facebook");
        }
        public void postOn(Twitter sns) {
            System.out.println("picture-twitter");
        }
    }

    // SNS
    interface SNS{
    }
    static class Facebook implements SNS {
    };
    static class Twitter implements SNS {
    };

    // main
    public static void main(String[] args) {
        List<Post> posts = Arrays.asList(new Text(),new Picture());
        List<SNS> sns = Arrays.asList(new Facebook(),new Twitter() // , new GooglePlus()
        );

        // 에러발생
        // 다이나믹 디스패치 수행 : 이중 for 문
        // posts.forEach( p -> sns.forEach( s -> p.postOn(s)));

        // ==
        // posts.forEach((Post p) -> sns.forEach((SNS s) -> p.postOn(s)));
    }
}