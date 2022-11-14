package dispatchtest;

public class DynamicDispatchTest {
    public static void main(String[] arg) {
            Printable dynamicDispatch = new DynamicDispatch();
            dynamicDispatch.print();

            PrintAbstract dynamicDispatchAbst = new DynamicDispatchAbstractChild();
            dynamicDispatchAbst.print();
    }
}
