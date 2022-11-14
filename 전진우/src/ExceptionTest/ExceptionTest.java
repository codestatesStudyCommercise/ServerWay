package ExceptionTest;

public class ExceptionTest {
    static class MyException extends RuntimeException {
        private final int ERROR_CODE;

        // 생성자를 통한 초기화
        MyException(String msg, int errCode) {
            super(msg);
            ERROR_CODE = errCode;
        }

        MyException(String msg) {
            this(msg, 100);
        }

        public int getERROR_CODE() {
            return ERROR_CODE;
        }
    }

    public static class ThrowExceptionTest{
        public void reThrowing() throws MyException{
            try {

                throw new MyException("첫번째 예외");

            } catch (MyException e) {

                System.out.println("첫번째 catch : e.getMessage() : " + e.getMessage());
                throw new MyException("두번째 예외");

            }
        }
    }

    // 설치 실패
    static class InstallException extends RuntimeException {
        private final int ERROR_CODE;

        // 생성자를 통한 초기화
        InstallException(String msg, int errCode) {
            super(msg);
            ERROR_CODE = errCode;
        }

        InstallException(String msg) {
            this(msg, 100);
        }

        public int getERROR_CODE() {
            return ERROR_CODE;
        }
    }

    // 설치 공간 부족
    static class NotEnoughSpaceException extends RuntimeException {
        private final int ERROR_CODE;

        // 생성자를 통한 초기화
        NotEnoughSpaceException(String msg, int errCode) {
            super(msg);
            ERROR_CODE = errCode;
        }

        NotEnoughSpaceException(String msg) {
            this(msg, 200);
        }

        public int getERROR_CODE() {
            return ERROR_CODE;
        }
    }

    // 설치작업 수행 메모리 부족
    static class NotEnoughMemoryException extends RuntimeException {
        private final int ERROR_CODE;

        // 생성자를 통한 초기화
        NotEnoughMemoryException(String msg, int errCode) {
            super(msg);
            ERROR_CODE = errCode;
        }

        NotEnoughMemoryException(String msg) {
            this(msg, 300);
        }

        public int getERROR_CODE() {
            return ERROR_CODE;
        }
    }

    public static class ChainedExceptionTest{

        // 남은 설치 공간 확인
        private boolean checkRemainSpace(){
            return false;
        }

        // 남은 설치작업을 수행할 메모리 확인
        private boolean checkRemainMemory(){
            return false;
        }

        // 설치 시작
        private void startInstall() throws NotEnoughSpaceException, NotEnoughMemoryException{
            if (!checkRemainSpace()){
                throw new NotEnoughSpaceException("설치 공간 부족 !!!!");
            }
            if (!checkRemainMemory()){
                throw new NotEnoughMemoryException("설치작업을 수행할 메모리 부족 !!!!");
            }
        }

        // 파일 복사
        private void copyFiles(){};

        // 임시파일 삭제
        private void deleteTempFiles(){};

        // 설치과정 수행
        public void install() throws InstallException{
            try {
                startInstall(); // 예외 발생
                copyFiles();
            } catch (NotEnoughSpaceException se){
                InstallException ie = new InstallException("설치중 예외 발생");
                ie.initCause(se);
                throw ie;
            } catch (NotEnoughMemoryException me){
                InstallException ie = new InstallException("설치중 예외 발생");
                ie.initCause(me);
                throw ie;
            } finally {
                deleteTempFiles();
            }
        }
    }

    public static void main(String[] args) {


        // 테스트3
        ChainedExceptionTest chainTest = new ChainedExceptionTest();
        try{
            chainTest.install();
        } catch (InstallException ie) {
            ie.printStackTrace();
        }

//        // 테스트2
//        ThrowExceptionTest throwExceptionTest = new ThrowExceptionTest();
//        try {
//            throwExceptionTest.reThrowing();
//        } catch (MyException e) {
//            System.out.println("두번째 catch : e.getMessage() : " + e.getMessage());
//        }

//        // 테스트1
//        try{
//            throw new MyException("예외 발생 !!!!!!");
//        } catch (Exception e) {
//            System.out.println("e.getMessage ----------------------------");
//            System.out.println(e.getMessage());
//            System.out.println();
//
//            System.out.println("e.toString ----------------------------");
//            System.out.println(e.toString());
//            System.out.println();
//
//            System.out.println("e.printStackTrace ----------------------------");
//            e.printStackTrace();
//            System.out.println("hello");
//        }
//
//        System.out.println(" 정상 종료 ");
//        System.out.println(" 정상 종료 ");
//        System.out.println(" 정상 종료 ");
//        System.out.println(" 정상 종료 ");
//        System.out.println(" 정상 종료 ");
//        System.out.println(" 정상 종료 ");
    }
}
