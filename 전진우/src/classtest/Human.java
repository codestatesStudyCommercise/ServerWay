package classtest;

public class Human extends Animal{

    private String name = "사람";
    private int legsNum = 2;
    private int handsNum = 2;

    public Human() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getLegsNum() {
        return legsNum;
    }

    @Override
    public void setLegsNum(int legsNum) {
        this.legsNum = legsNum;
    }

    public int getHandsNum() {
        return handsNum;
    }

    public void setHandsNum(int handsNum) {
        this.handsNum = handsNum;
    }
}
