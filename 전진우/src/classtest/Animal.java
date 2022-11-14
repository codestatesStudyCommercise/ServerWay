package classtest;

public class Animal {

    private String name = "동물";
    private int eyesNum = 2;
    private int legsNum = 4;

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEyesNum() {
        return eyesNum;
    }

    public void setEyesNum(int eyesNum) {
        this.eyesNum = eyesNum;
    }

    public int getLegsNum() {
        return legsNum;
    }

    public void setLegsNum(int legsNum) {
        this.legsNum = legsNum;
    }
}
