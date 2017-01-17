public class OldThreadPi extends Thread{

    private final long dropsToUse;
    private long pResult;

    public long getpResult() {
        return pResult;
    }

    public OldThreadPi(long drops, long countOfThreads) {
        this.dropsToUse = drops / countOfThreads;
    }

    @Override
    public void run() {
        for (long i = 0; i < dropsToUse; i++) {
            double x = Math.random();
            double y = Math.random();

            if (x * x + y * y <= 1) {
                pResult++;
            }
        }

    }

}