public class App {
    public static void main(String[] args) throws Exception {
        Config config = new Config();

        Kiosk kiosk = new Kiosk(
                config.getProductRepository(),
                config.getMenu(),
                config.getCart(),
                config.getDiscount(),
                config.getOrder());

        kiosk.start();
    }
}
