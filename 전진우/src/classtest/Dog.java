package classtest;

public class Dog extends Animal{

    private String name = "멍멍이";

    public Dog() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
