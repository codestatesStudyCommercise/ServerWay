package others.test;


import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForTest {

    //Student.java
    static public class Student {
        public enum Gender {Male, Female};
        private String name;
        private int score;
        private Gender gender;

        public Student(String name, int score, Gender gender) {
            this.name = name;
            this.score = score;
            this.gender = gender;
        }

        public Gender getGender(){
            return gender;
        }

        public String getName(){
            return name;
        }

        public int getScore(){
            return score;
        }
    }
    public static void main(String[] args) {

        String obj = new String();


        ArrayList list = new ArrayList(); // 제네릭 타입 미지정
        list.add(obj); // 경고 발생 지점

//        try {
//            FileInputStream fileInput = new FileInputStream("src/others/test/testFile.txt");
//            int i = 0;
//            while ((i = fileInput.read()) != -1) { //fileInput.read()의 리턴값을 i에 저장한 후, 값이 -1인지 확인합니다.
//                System.out.print((char)i);
//            }
//            fileInput.close();
//        }
//        catch (Exception e) {
//            System.out.println(e);
//        }


//        List<String> languages = Arrays.asList(
//                "Ruby", "Python", "Java", "Go", "Kotlin");
//        Optional<List<String>> listOptional = Optional.of(languages);
//
//        int size = listOptional
//                .map(List::size)
//                .orElse(0);
//        System.out.println(size);
//
//
//        System.out.println();
//
//        Optional<String> optString = Optional.of("codestates");
//        System.out.println(optString);
//        System.out.println(optString.get());
//
//        String nullName = null;
//        String name = Optional.ofNullable(nullName).orElse("kimcoding");
//        System.out.println(name);
//
//        System.out.println();
//
//        List<Student> totalList = Arrays.asList(
//                new Student("김코딩", 10, Student.Gender.Male),
//                new Student("김인기", 8, Student.Gender.Male),
//                new Student("이자바", 9, Student.Gender.Female),
//                new Student("최민선", 10, Student.Gender.Female)
//        );
//
//        List<Student> maleList = totalList.stream()
//                .filter(s -> s.getGender() == Student.Gender.Male)
//                .collect(Collectors.toList());
//
//        maleList.stream().forEach(n->System.out.println(n.getName()));
//
//        System.out.println();
//
//        Set<Student> femaleSet = totalList.stream()
//                .filter(s -> s.getGender() == Student.Gender.Female)
//                .collect(Collectors.toCollection(HashSet:: new));
//
//        femaleSet.stream().forEach(n->System.out.println(n.getName()));

    }
}
