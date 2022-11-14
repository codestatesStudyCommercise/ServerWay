package ExceptionTest;

public class TryWithResourceTest {
    static class CloseableResource implements AutoCloseable {
        public void executeFirstException(boolean exception) throws FirstException{
            System.out.println("executeException() 호출 !! 예외 throw 여부 : " + exception);
            if (exception){
                throw new FirstException("executeException() 에서 발생");
            }
        }
        public void close() throws CloseException {
            System.out.println("close() 호출 !!! 무조건 CloseException 발생 ");
            throw new CloseException("close() 에서 발생");
        }

    }
    static class FirstException extends Exception {
            FirstException(String msg) {
                super(msg);
            }
    }
    static class CloseException extends Exception {
        CloseException(String msg) {
            super(msg);
        }
    }

    public static void main(String[] args) {
        try (CloseableResource cr = new CloseableResource()) {
            // 매개변수 boolean 값에 따라 예외 throw 여부 결정
            cr.executeFirstException(false);

        } catch (FirstException fe) {
            fe.printStackTrace();
        } catch (CloseException ce) {
            ce.printStackTrace();
        }
        System.out.println();
        System.out.println("-".repeat(50));
        System.out.println();
    }
}


