package others;

public class ThreadMain {
    public static void main(String[] args) {
        // 쓰레드 생성 및 실행
        Runnable r = new UsingThread();
        new Thread(r).start();
        new Thread(r).start();
    }
}

// 지갑 클래스
class Wallet {
    private int myMoney = 1000;

    public int getMyMoney() {
        return myMoney;
    }

    // 지갑에 돈이 있으면 구매 후 지갑 잔액 차감
    public void useBuy(int price){
        try{
            Thread.sleep(1000);
            } catch (InterruptedException e) {}
        if (myMoney >= price) {
            myMoney -= price;
        }
    }
}

// 쓰레드 구성
class UsingThread implements Runnable{
    Wallet wallet = new Wallet();

    @Override
    public void run() {
        // 지갑에 잔액이 0원 이상이면 인출
        while(wallet.getMyMoney() > 0){
            wallet.useBuy(100);
            System.out.println("myMoney : " + wallet.getMyMoney());
        }
        System.out.println("result = " + wallet.getMyMoney());
    }
}