package Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
    static class usingGenerics{

        public void listParamTest(List<? super String> list, String obj){
            list.add(obj);
            System.out.println(list.get(0));
        }

    }

    public static void main(String[] args) {

        List<Object> listObj = new ArrayList<>();
        listObj.add("heellsd");
        listObj.add(Integer.valueOf(3));
        listObj.add(Double.valueOf(3));

        List<String> listString = new ArrayList<>();

        usingGenerics usingGenerics = new usingGenerics();
        usingGenerics.listParamTest(listObj, "hello");
        usingGenerics.listParamTest(listString, "hello");
    }
}
