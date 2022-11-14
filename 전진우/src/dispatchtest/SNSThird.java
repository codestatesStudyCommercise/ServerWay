package dispatchtest;

import java.util.Arrays;
import java.util.List;

public class SNSThird {

    /*
        3. 객체지향스러운 결과 : SNS 를 새로 추가하는것이 자유롭고 코드를 추가하는 시점에서 의존하는 코드(Post 측)에 직접적인 영향을 주지 않음
                            Post 측의 변경이 일어날때는 다른 고민이 필요함
     */

    // Post
    interface Post {
        // 3. 다시 원상복귀 SNS 타입으로 받는다.
        void postOn(SNS sns);
    }
    static class Text implements Post {
        // 문제 지점
        // 3. 구현을 SNS 로 옮긴다.
        public void postOn(SNS sns) {
            sns.post(this); // sns의 post 를 호출하고 자기 자신을 넘기도록 구현
            // 다이나믹 디스패칭 시점 2. : sns 에 대한 다이나믹 디스패칭이 일어남
        }
    }
    static class Picture implements Post {
        // 문제 지점
        // 3. 구현을 SNS 로 옮긴다.
        public void postOn(SNS sns) {
            sns.post(this); // sns의 post 를 호출하고 자기 자신을 넘기도록 구현
            // 다이나믹 디스패칭 시점 2. : sns 에 대한 다이나믹 디스패칭이 일어남
        }
    }

    // SNS
    interface SNS{
        // 3. 메서드 추가
        void post(Text post);
        void post(Picture post);
    }
    static class Facebook implements SNS {
        // 3. 구현 추가
        public void post(Text post) {
            System.out.println("text-facebook");
        }
        // 3. 구현 추가
        public void post(Picture post) {
            System.out.println("picture-facebook");
        }
    };
    static class Twitter implements SNS {
        // 3. 구현 추가
        public void post(Text post) {
            System.out.println("text-twitter");
        }
        // 3. 구현 추가
        public void post(Picture post) {
            System.out.println("picture-twitter");
        }
    };
    // 새로운 SNS 추가
    static class GooglePlus implements SNS {
        // 3. 구현 추가
        public void post(Text post) {
            System.out.println("text-google plus");
        }
        // 3. 구현 추가
        public void post(Picture post) {
            System.out.println("picture-google plus");
        }
    };

    // main
    public static void main(String[] args) {
        List<Post> posts = Arrays.asList(new Text(),new Picture());
        List<SNS> sns = Arrays.asList(new Facebook(),new Twitter() ,new GooglePlus());

        // 에러발생
        // 다이나믹 디스패치 수행
        posts.forEach( p -> sns.forEach( s -> p.postOn(s))); // 다이나믹 디스패칭 시점 1.

        // ==
        // posts.forEach((Post p) -> sns.forEach((SNS s) -> p.postOn(s)));
    }
}