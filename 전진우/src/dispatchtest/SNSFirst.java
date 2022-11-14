package dispatchtest;

import java.util.Arrays;
import java.util.List;

public class SNSFirst {

    // 첫번째 시도
    /*
    문제점 1. 객체의 타입을 판별하는 방식으로 if 문 로직을 사용함 (instanceof 는 안티패턴으로 많이 지적되는 경우)
             1-1. if 문 로직에 걸리지 않을 수도 있으며 if 문 로직을 그대로 통과해버리면 로직에 장애가 발생
             1-2. 새로운 SNS 종류가 추가 될 시 새로운 SNS 타입을 반영하는 if 문 로직을 추가해줘야함 : 잊고 빼먹을 여지가 있음
             [개선 시도 ->]
     */

    // Post
    interface Post {
        void postOn(SNS sns);
    }
    static class Text implements Post {
        public void postOn(SNS sns) {
            // 문제 지점
            if (sns instanceof Facebook) {
                System.out.println("text - facebook");
            }
            if (sns instanceof Twitter) {
                System.out.println("text - twitter");
            }
//            if (sns instanceof GooglePlus) {
//                System.out.println("text - google plus");
//            }

        }
    }
    static class Picture implements Post {
        public void postOn(SNS sns) {
            // 문제 지점
            if (sns instanceof Facebook) {
                System.out.println("picture - facebook");
            }
            if (sns instanceof Twitter) {
                System.out.println("picture - twitter");
            }
        }
    }

    // SNS
    interface SNS{

    }
    static class Facebook implements SNS {
    };
    static class Twitter implements SNS {
    };
//    static class GooglePlus implements SNS {
//    };

    // main
    public static void main(String[] args) {
        List<Post> posts = Arrays.asList(new Text(),new Picture());
        List<SNS> sns = Arrays.asList(new Facebook(),new Twitter() // , new GooglePlus()
        );

        // 다이나믹 디스패치 수행 : 이중 for문
        posts.forEach( p -> sns.forEach( s -> p.postOn(s)));

        // ==
        // posts.forEach((Post p) -> sns.forEach((SNS s) -> p.postOn(s)));
    }
}